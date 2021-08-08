package com.example.butanogas.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.butanogas.entity.AddressEntity;
import com.example.butanogas.entity.OrderEntity;
import com.example.butanogas.entity.PaymentEntity;

@Database(entities = {AddressEntity.class, OrderEntity.class, PaymentEntity.class}, version = 5)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDatabase;

    public abstract AddressDAO createAddressDAO();
    public abstract OrderDAO createOrderDAO();
    public abstract PaymentDAO createPaymentDAO();

    public static AppDataBase getInstance(Context context) {
        if(appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "butano_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }
}
