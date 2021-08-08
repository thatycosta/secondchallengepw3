package com.example.butanogas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.butanogas.R;
import com.example.butanogas.entity.OrderEntity;
import com.example.butanogas.entity.PaymentEntity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<OrderEntity> orders = new ArrayList<>();

    public Adapter(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false);
        this.context = viewGroup.getContext();
        return new ViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int position) {
            OrderEntity orderEntity = (OrderEntity) orders.get(position);
            viewHolder.name.setText("Cliente: " + orderEntity.getClientName());
            viewHolder.phone.setText("Telefone: " + orderEntity.getPhone());
            viewHolder.totalPrice.setText("Valor Total do Pedido: " + orderEntity.getTotalPrice());
            viewHolder.typeOfPayment.setText("Tipo de Pagamento: "  + orderEntity.getPaymentEntity().getTypeOfPayment());
            if(!orderEntity.getPaymentEntity().getTypeOfPayment().equals("Dinheiro")){
                viewHolder.cardNumber.setText(orderEntity.getPaymentEntity().getCardNumber());
            }else{
                viewHolder.cardNumber.setText("-");
            }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phone;
        TextView typeOfPayment;
        TextView cardNumber;
        TextView totalPrice;

        public ViewHolder(View itemView){
           super(itemView);
            name = itemView.findViewById(R.id.textViewClientName);
            phone = itemView.findViewById(R.id.textViewPhone);
            typeOfPayment = itemView.findViewById(R.id.textViewTypeOfPayment);
            cardNumber = itemView.findViewById(R.id.textCardNumber);
            totalPrice = itemView.findViewById(R.id.textViewTotalPrice);
        }
    }
}
