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
    List<Object> orders = new ArrayList<>();

    public Adapter(List<Object> orders) {
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
        if(orders.get(position) instanceof OrderEntity){
            //Object test = orders.get(position + 2);
            OrderEntity orderEntity = (OrderEntity) orders.get(position);
            viewHolder.name.setText(orderEntity.getClientName());
            viewHolder.phone.setText(orderEntity.getPhone());
            viewHolder.totalPrice.setText(orderEntity.getTotalPrice());
            viewHolder.typeOfPayment.setText("Dinheiro");
            //PaymentEntity paymentEntity = (PaymentEntity) test;
            //viewHolder.typeOfPayment.setText(paymentEntity.getTypeOfPayment());
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i) instanceof OrderEntity){
                size++;
            }
        }


        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phone;
        TextView typeOfPayment;
        TextView totalPrice;

        public ViewHolder(View itemView){
           super(itemView);
            name = itemView.findViewById(R.id.textViewClientName);
            phone = itemView.findViewById(R.id.textViewPhone);
            typeOfPayment = itemView.findViewById(R.id.textViewTypeOfPayment);
            totalPrice = itemView.findViewById(R.id.textViewTotalPrice);
        }
    }
}
