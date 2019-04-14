package com.example.databasesekolah.main;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.databasesekolah.entity.AppDatabase;
import com.example.databasesekolah.entity.DataSekolah;

public class MainPresenter implements MainContract.presenter {
    MainContract.view view;
    MainContract.hapus viewH;
    public MainPresenter(MainContract.view view) {
        this.view = view;
    }
    public MainPresenter(MainContract.hapus viewH) {
        this.viewH = viewH;
    }
    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataSekolah dataSekolah;
        public EditData(AppDatabase database, DataSekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataSekolah);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.success();
        }
    }

    @Override
    public void editData(String namasekolah, String alamat, String jmlsiswa, String jmlguru,  int id, AppDatabase database) {
        final DataSekolah dataSekolah = new DataSekolah();
        dataSekolah.setNamasekolah(namasekolah);
        dataSekolah.setAlamat(alamat);
        dataSekolah.setJmlsiswa(jmlsiswa);
        dataSekolah.setJmlguru(jmlguru);
        dataSekolah.setId(id);
        new EditData(database, dataSekolah).execute();
    }
    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataSekolah dataSekolah;
        Context context;
        public DeleteData(AppDatabase database, DataSekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataSekolah);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.success();
        }

    }
    @Override
    public void deleteData(DataSekolah dataSekolah, AppDatabase database) {
        new DeleteData(database,dataSekolah).execute();
    }
}
