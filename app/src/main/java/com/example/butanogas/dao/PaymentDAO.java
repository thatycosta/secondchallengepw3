package com.example.butanogas.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.butanogas.entity.PaymentEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PaymentDAO  {
    @Query("SELECT * FROM PaymentEntity")
    public List<PaymentEntity> getAllPaymentEntities();

    @Insert(onConflict = REPLACE)
    public void insert(PaymentEntity paymentEntity);

    @Update
    public void update(PaymentEntity paymentEntity);

    @Delete
    public void delete(PaymentEntity paymentEntity);
}
