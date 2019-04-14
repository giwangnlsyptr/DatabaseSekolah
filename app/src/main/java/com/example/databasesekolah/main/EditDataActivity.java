package com.example.databasesekolah.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasesekolah.R;
import com.example.databasesekolah.entity.AppDatabase;
import com.example.databasesekolah.entity.DataSekolah;

public class EditDataActivity extends AppCompatActivity implements MainContract.view {
    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    EditText etNamaSekolah, etAlamat, etJmlSiswa, etJmlGuru;
    Button bSave;
    String sNamaSekolah, sAlamat, sJmlSiswa, sJmlGuru;
    private boolean edit = false;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        etNamaSekolah = findViewById(R.id.etnamasekolah);
        etAlamat = findViewById(R.id.etalamat);
        etJmlSiswa = findViewById(R.id.etjmlsiswa);
        etJmlGuru = findViewById(R.id.etjmlguru);
        bSave = findViewById(R.id.bsave);

        mainPresenter = new MainPresenter(this);

        appDatabase = AppDatabase.iniDb(getApplicationContext());
        sNamaSekolah = getIntent().getStringExtra("namasekolah");
        sAlamat = getIntent().getStringExtra("alamat");
        sJmlSiswa = getIntent().getStringExtra("jmlsiswa");
        sJmlGuru = getIntent().getStringExtra("jmlguru");
        id = getIntent().getIntExtra("id", 99);
        etNamaSekolah.setText(sNamaSekolah);
        etAlamat.setText(sAlamat);
        etJmlSiswa.setText(sJmlSiswa);
        etJmlGuru.setText(sJmlGuru);
        bSave.setOnClickListener(this);
    }

    @Override
    public void resetForm() {
        etNamaSekolah.setText("");
        etAlamat.setText("");
        etJmlSiswa.setText("");
        etJmlGuru.setText("");
        bSave.setText("Save");
    }

    @Override
    public void success() {
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), LihatDataActivity.class));
    }

    @Override
    public void editData(DataSekolah item) {
        etNamaSekolah.setText(item.getNamasekolah());
        etAlamat.setText(item.getAlamat());
        etJmlSiswa.setText(item.getJmlsiswa());
        etJmlGuru.setText(item.getJmlguru());
        edit = true;
        bSave.setText("Update");
    }

    @Override
    public void onClick(View v) {
        sNamaSekolah = etNamaSekolah.getText().toString();
        sAlamat = etAlamat.getText().toString();
        sJmlSiswa = etJmlSiswa.getText().toString();
        sJmlGuru = etJmlGuru.getText().toString();
        if(v ==  bSave){
            if(sNamaSekolah.equals("") || sAlamat.equals("") || sJmlSiswa.equals("") || sJmlGuru.equals("")) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show();
            } else {

                mainPresenter.editData(sNamaSekolah, sAlamat, sJmlSiswa, sJmlGuru, id, appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}

