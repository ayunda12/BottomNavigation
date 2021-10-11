package com.example.myfragmentbottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import com.shashank.sony.fancytoastlib.FancyToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    //Mendeklarasikan bottom navigation
    private MeowBottomNavigation bottomNavigation_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menambah item menu dalam kode.
        //Menambah ikon di Navigasi Bawah
        bottomNavigation_main = findViewById(R.id.bottomnavigation_main);
        bottomNavigation_main.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        bottomNavigation_main.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_search_24));
        bottomNavigation_main.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_video_library_24));
        bottomNavigation_main.add(new MeowBottomNavigation.Model(4,R.drawable.ic_baseline_shopping_bag_24));
        bottomNavigation_main.add(new MeowBottomNavigation.Model(5,R.drawable.ic_baseline_person_24));

        //Untuk menampilkan tampilan mana yang lebih dahulu ditampilkan ketika membuka aplikasi
        bottomNavigation_main.show(1,true);
        //Untuk menampilkan fragment sesuai id dan icon dari bottom navigation
        replace(new HomeFragment());

        //Menggunakan fungsi setOnClickMenuListener() untuk mengakses ketika item di bottom navigation diklik
        bottomNavigation_main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                //memberikan kondisi switch case, dimana setiap id dari item yang diklik,
                // akan menampilkan fragment dan toast message sesuai case id nya
                switch (model.getId()){
                    case 1:
                        replace(new HomeFragment());
                        FancyToast.makeText(MainActivity.this,"Anda Masuk ke Menu Home",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                        break;
                    case 2:
                        replace(new SearchFragment());
                        FancyToast.makeText(MainActivity.this,"Anda Masuk ke Menu Pencarian",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                        break;
                    case 3:
                        replace(new VideoFragment());
                        FancyToast.makeText(MainActivity.this,"Anda Masuk ke Menu Video",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                        break;
                    case 4:
                        replace(new StoreFragment());
                        FancyToast.makeText(MainActivity.this,"Anda Masuk ke Menu Toko",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                        break;
                    case 5:
                        replace(new AccountFragment());
                        FancyToast.makeText(MainActivity.this,"Anda Masuk ke Menu Akun",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                        break;
                }
                return null;
            }
        });

    }

    private void replace(Fragment fragment) {
        //Membuat sebuah fragmentTransaction untuk memulai transaksi dan mengganti fragment
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        //Mengganti apa pun yang ada di tampilan frame dengan fragment yang baru
        transaction.replace(R.id.frame,fragment);
        //simpan perubahan
        transaction.commit();
    }

}