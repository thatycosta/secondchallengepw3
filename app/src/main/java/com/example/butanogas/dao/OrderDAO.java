package com.example.butanogas.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.butanogas.entity.OrderEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface OrderDAO {

    @Query("SELECT * FROM OrderEntity")
    public List<OrderEntity> getAllOrders();

    @Insert(onConflict = REPLACE)
    public void insert(OrderEntity orderEntity);

    @Update
    public void update(OrderEntity orderEntity);

    @Delete
    public void delete(OrderEntity orderEntity);

}
