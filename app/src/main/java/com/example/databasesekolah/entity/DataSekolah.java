package com.example.databasesekolah.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "sekolahdb")

public class DataSekolah {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "namasekolah")
    private String namasekolah;

    @ColumnInfo(name = "alamat")
    private String alamat;

    @ColumnInfo(name = "jmlsiswa")
    private String jmlsiswa;

    @ColumnInfo(name = "jmlguru")
    private String jmlguru;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamasekolah() {
        return namasekolah;
    }

    public void setNamasekolah(String namasekolah) {
        this.namasekolah = namasekolah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJmlsiswa() {
        return jmlsiswa;
    }

    public void setJmlsiswa(String jmlsiswa) {
        this.jmlsiswa = jmlsiswa;
    }

    public String getJmlguru() {
        return jmlguru;
    }

    public void setJmlguru(String jmlguru) {
        this.jmlguru = jmlguru;
    }
}