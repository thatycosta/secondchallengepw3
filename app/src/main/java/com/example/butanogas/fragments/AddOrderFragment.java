package com.example.butanogas.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.butanogas.R;
import com.example.butanogas.dao.AppDataBase;
import com.example.butanogas.dao.OrderDAO;
import com.example.butanogas.dao.PaymentDAO;
import com.example.butanogas.entity.OrderEntity;
import com.example.butanogas.entity.PaymentEntity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddOrderFragment extends Fragment {
    private TextInputEditText clientName;
    private TextInputEditText phone;
    private TextInputEditText totalPrice;
    private TextInputEditText typeOfPayment;
    private TextInputEditText cardNumber;
    private TextInputEditText cardData;
    private TextInputEditText securityCode;
    private Button btnCreate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_order, container, false);
        clientName = root.findViewById(R.id.clientName);
        phone = root.findViewById(R.id.phone);
        typeOfPayment = root.findViewById(R.id.typeOfPayment);
        cardNumber = root.findViewById(R.id.cardNumber);
        cardData = root.findViewById(R.id.cardData);
        securityCode = root.findViewById(R.id.securityCode);
        btnCreate = root.findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void,Integer, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... voids) {
                        OrderDAO orderDAO = AppDataBase.getInstance(getContext().getApplicationContext()).createOrderDAO();
                        PaymentDAO paymentDAO = AppDataBase.getInstance(getContext().getApplicationContext()).createPaymentDAO();

                        OrderEntity orderEntity = new OrderEntity();
                        PaymentEntity paymentEntity = new PaymentEntity();

                        orderEntity.setClientName(clientName.getText().toString());
                        orderEntity.setPhone(phone.getText().toString());
                        orderEntity.setTotalPrice("100");
                        orderDAO.insert(orderEntity);

                        paymentEntity.setTypeOfPayment(typeOfPayment.getText().toString());
                        paymentEntity.setCardNumber(cardNumber.getText().toString());
                        paymentEntity.setCardData(cardData.getText().toString());
                        paymentEntity.setSecurityCode(securityCode.getText().toString());
                        paymentDAO.insert(paymentEntity);

                        return orderEntity.getId();
                    }
                }.execute();

                Snackbar snackbar = Snackbar.make(view, "Pedido criado com sucesso!", Snackbar.LENGTH_LONG);
                snackbar.show();
                Navigation.findNavController(view).navigate(R.id.action_nav_create_to_nav_list);
            }
        });
        return root;
    }


}
