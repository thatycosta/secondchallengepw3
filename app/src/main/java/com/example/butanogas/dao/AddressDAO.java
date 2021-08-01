package com.example.butanogas.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.butanogas.entity.AddressEntity;
import com.example.butanogas.entity.OrderEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface AddressDAO {
    @Query("SELECT * FROM AddressEntity")
    public List<AddressEntity> getAllAddresses();

    @Insert(onConflict = REPLACE)
    public void insert(AddressEntity addressEntity);

    @Update
    public void update(AddressEntity addressEntity);

    @Delete
    public void delete(AddressEntity addressEntity);
}
