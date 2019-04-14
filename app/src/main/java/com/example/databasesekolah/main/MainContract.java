package com.example.databasesekolah.main;

import android.view.View;

import com.example.databasesekolah.entity.AppDatabase;
import com.example.databasesekolah.entity.DataSekolah;

import java.util.List;

public interface MainContract {
    interface view extends View.OnClickListener{
        void success();
        void resetForm();
        void editData(DataSekolah item);
    }
    interface presenter{
        void editData(String namasekolah, String alamat, String jumlahsiswa, String jumlahguru, int id, AppDatabase database);
        void deleteData(DataSekolah dataSekolah, AppDatabase database);
    }

    interface tampil extends View.OnClickListener{
        void getData(List<DataSekolah> list);
    }

    interface hapus{
        void success();
        void deleteData(DataSekolah item);
    }
}
