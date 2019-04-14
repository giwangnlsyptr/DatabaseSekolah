package com.example.databasesekolah.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.databasesekolah.R;
import com.example.databasesekolah.entity.DataSekolah;

import java.util.List;

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.ViewHolder>{
    Context context;
    List<DataSekolah> list;
    MainContract.hapus view;
    public MainAdapter(Context context, List<DataSekolah> list, MainContract.hapus view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DataSekolah data = list.get(i);
        viewHolder.tvNamaSekolah.setText(data.getNamasekolah());
        viewHolder.tvAlamat.setText(data.getAlamat());
        viewHolder.tvJmlSiswa.setText(data.getJmlsiswa());
        viewHolder.tvJmlGuru.setText(data.getJmlguru());
        viewHolder.bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.deleteData(data);
                // return true;
            }
        });
        viewHolder.bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(context, EditDataActivity.class);
                x.putExtra("namasekolah", data.getNamasekolah());
                x.putExtra("alamat", data.getAlamat());
                x.putExtra("jmlsiswa", data.getJmlsiswa());
                x.putExtra("jmlguru", data.getJmlguru());
                x.putExtra("id", data.getId());
                x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaSekolah, tvAlamat, tvJmlSiswa, tvJmlGuru;
        Button bDelete, bEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaSekolah = itemView.findViewById(R.id.tvnamasekolah);
            tvAlamat = itemView.findViewById(R.id.tvalamat);
            tvJmlSiswa = itemView.findViewById(R.id.tvjmlsiswa);
            tvJmlGuru = itemView.findViewById(R.id.tvjmlguru);
            bDelete = itemView.findViewById(R.id.bdelete);
            bEdit = itemView.findViewById(R.id.bedit);
        }
    }
}
