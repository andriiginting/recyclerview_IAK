package com.example.andriginting.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView rv;
//    private EditText tambah;
    private List<KontenModel> kontenModels;
    private KontenAdapter adapter;
   // private FloatingActionButton fb;

//    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("IAK Intermediate");
        rv = findViewById(R.id.recyclerPAPB);
        //fb = (FloatingActionButton)findViewById(R.id.float_button);

        kontenModels = new ArrayList<>();

//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogForm();
//            }
//        });

        adapter = new KontenAdapter(this,kontenModels);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        rv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        rv.setAdapter(adapter);
        prepareModel();

    }

    private void prepareModel(){
        String thumbnail [] =new String []{
                "https://instagram.fsub3-1.fna.fbcdn.net/t51.2885-15/s150x150/e35/c0.135.1080.1080/21433897_929245477237853_8943585815515103232_n.jpg",
                "https://instagram.fsub3-1.fna.fbcdn.net/t51.2885-15/s240x240/e35/c0.1.1080.1080/23596122_146272852766420_7032503373714685952_n.jpg",
                "https://instagram.fsub3-1.fna.fbcdn.net/t51.2885-15/s240x240/e35/c0.135.1080.1080/21433897_929245477237853_8943585815515103232_n.jpg",
                "https://instagram.fsub3-1.fna.fbcdn.net/t51.2885-15/s640x640/sh0.08/e35/c181.0.718.718/20986660_385385578531421_3402517836860489728_n.jp",
                "https://instagram.fsub3-1.fna.fbcdn.net/t51.2885-15/s640x640/sh0.08/e35/c40.0.999.999/19933389_1721246924841881_7804251847971045376_n.jpg"
        };

        KontenModel a = new KontenModel(thumbnail[0],"Saya");
        kontenModels.add(a);

        a = new KontenModel(thumbnail[1],"Andri");
        kontenModels.add(a);

        a = new KontenModel(thumbnail[2],"Suranta");
        kontenModels.add(a);

        a = new KontenModel(thumbnail[1],"Ginting");
        kontenModels.add(a);

        a = new KontenModel(thumbnail[4],"Android");
        kontenModels.add(a);

        a = new KontenModel(thumbnail[1],"Developer");
        kontenModels.add(a);

        adapter.notifyDataSetChanged();
    }

//    private void dialogForm(){
//        dialog = new AlertDialog.Builder(this);
//        final View dialogView = LayoutInflater.from(this)
//                .inflate(R.layout.alert_layout,null);
//        dialog.setView(dialogView);
//        dialog.setTitle("Tambah Item");
//        dialog.setCancelable(true);
//
//        tambah=(EditText)findViewById(R.id.tambah_item);
//
//        dialog.setPositiveButton("Tambah Item", new DialogInterface.OnClickListener() {
//            int a = simbol(tambah.getText().toString());
//            String nama = tambah.getText().toString();
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                KontenModel model = new KontenModel("",nama);
//                kontenModels.add(model);
//                adapter.notifyDataSetChanged();
//                dialogInterface.dismiss();
//            }
//        });
//        dialog.show();
//    }

    private int simbol(String nama){
        int gambar = 0;
        switch (nama){
            case "android":
                gambar = R.mipmap.ic_launcher;
                break;
            case "iOS":
                gambar = R.drawable.apel;
                break;
            case "blackberry":
                gambar = R.drawable.bb;
                break;
            case " ubuntu":
                gambar = R.drawable.ubuntu;
                break;
            case "windows":
                gambar = R.drawable.windows;
                break;
                default:
                    gambar = R.mipmap.ic_launcher;
        }

        return gambar;
    }
}
