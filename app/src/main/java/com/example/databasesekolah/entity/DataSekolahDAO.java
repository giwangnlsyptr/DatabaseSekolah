package com.example.databasesekolah.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.databasesekolah.entity.DataSekolah;

import java.util.List;

@Dao
public interface DataSekolahDAO {
    @Insert
    long insertData(DataSekolah dataSekolah);

    @Query("Select * from sekolahdb")
    List<DataSekolah> getData();

    @Update
    int updateData(DataSekolah item);

    @Delete
    void deleteData(DataSekolah item);
}
