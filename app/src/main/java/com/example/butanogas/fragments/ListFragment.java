package com.example.butanogas.fragments;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.butanogas.R;
import com.example.butanogas.adapter.Adapter;
import com.example.butanogas.dao.AppDataBase;
import com.example.butanogas.dao.OrderDAO;
import com.example.butanogas.dao.PaymentDAO;
import com.example.butanogas.entity.OrderEntity;
import com.example.butanogas.entity.PaymentEntity;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @SuppressLint("StaticFieldLeak")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        new AsyncTask<Void,Void, List<OrderEntity>>() {

            @Override
            protected List<OrderEntity> doInBackground(Void... voids) {
                OrderDAO orderDAO = AppDataBase.getInstance(getContext().getApplicationContext()).createOrderDAO();
                return orderDAO.getAllOrders();
            }

            @Override
            protected void onPostExecute(List<OrderEntity> orders) {
                super.onPostExecute(orders);
                getAll(orders);
            }

        }.execute();

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }

    protected  void getAll(List<OrderEntity> orders){
        recyclerView.setAdapter(new Adapter(orders));
    }
}
