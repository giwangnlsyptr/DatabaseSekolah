package com.example.databasesekolah.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasesekolah.R;
import com.example.databasesekolah.entity.AppDatabase;
import com.example.databasesekolah.entity.DataSekolah;

public class MainActivity extends AppCompatActivity {
    EditText etNamaSekolah, etAlamat, etJmlSiswa, etJmlGuru;
    Button bSave, bLihat;
    String sNamaSekolah, sAlamat, sJmlSiswa, sJmlGuru;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNamaSekolah = findViewById(R.id.etnamasekolah);
        etAlamat = findViewById(R.id.etalamat);
        etJmlSiswa = findViewById(R.id.etjmlsiswa);
        etJmlGuru = findViewById(R.id.etjmlguru);
        bSave = findViewById(R.id.bsave);
        bLihat = findViewById(R.id.blihat);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
            }
        });
        bLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), LihatDataActivity.class);
                startActivity(x);
            }
        });
    }

    public void input(){
        sNamaSekolah = etNamaSekolah.getText().toString();
        sAlamat = etAlamat.getText().toString();
        sJmlSiswa = etJmlSiswa.getText().toString();
        sJmlGuru = etJmlGuru.getText().toString();
        final DataSekolah dataSekolah = new DataSekolah();
        dataSekolah.setNamasekolah(sNamaSekolah);
        dataSekolah.setAlamat(sAlamat);
        dataSekolah.setJmlsiswa(sJmlSiswa);
        dataSekolah.setJmlguru(sJmlGuru);
        new InsertData(appDatabase, dataSekolah).execute();
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataSekolah dataSekolah;

        public InsertData(AppDatabase database, DataSekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataSekolah);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

        }

    }

}
