package com.example.andriginting.recyclerview;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andri Ginting on 11/8/2017.
 */

public class KontenAdapter extends RecyclerView.Adapter<KontenAdapter.ViewHolder> {
    private Context context;
    private List<KontenModel> kontenModelList;

    public KontenAdapter(Context context, List<KontenModel> list){
        this.context =context;
        this.kontenModelList = list;
    }
    @Override
    public KontenAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.konten_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(KontenAdapter.ViewHolder holder, final int position) {
        final KontenModel kontenModel = kontenModelList.get(position);
        holder.nama.setText(kontenModel.getNama());

        Picasso.with(context)
                .load(kontenModel.getGambar())
                .resize(200,200)
                .into(holder.thumbnail);
        Log.v("gambar", kontenModel.getGambar()+"");

        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusItem(position);
                showDeletNotification(kontenModel.getNama());
                Toast.makeText(context,kontenModel.getNama(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //untuk menampilkan notifikasi
    private void showDeletNotification( String pesan){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("File Dihapus...")
                .setContentText(pesan);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, mBuilder.build());
    }

    //untuk menghapus item
    private void hapusItem(int posisi){
        kontenModelList.remove(posisi);
        notifyItemRemoved(posisi);
        notifyItemRangeChanged(posisi,kontenModelList.size());
    }
    @Override
    public int getItemCount() {
        return kontenModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;
        public TextView nama;
        public LinearLayout ln;
        public ViewHolder(View v) {
            super(v);

            thumbnail =(ImageView)v.findViewById(R.id.thumbnail_kontent);
            nama =(TextView)v.findViewById(R.id.nama_kontent);
            ln=(LinearLayout)v.findViewById(R.id.linear_button);
        }
    }
}
