package com.h5170062.kadir_enes_isler_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5170062.kadir_enes_isler_final.R;
import com.h5170062.kadir_enes_isler_final.util.NetworkUtil;

public class SplashEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ekrani);
        startTimer();
    }
    private void startTimer()
    {
        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                if (NetworkUtil.internetKontrol(getApplicationContext()))
                {
                    // diğer ekrana geç
                    Intent ListeEkrani = new Intent(getApplicationContext(),ListeEkrani.class);
                    startActivity(ListeEkrani);
                    finish();
                }
                else
                {
                    Dialog();
                }
            }
        };
        countDownTimer.start();
    }
    private void Dialog()
    {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("İnternet Bağlantınız Yok");
        build.setMessage("Uygulamayı kullanmak için internete bağlayın");
        build.setPositiveButton("İnterneti Aç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface pencere, int which) {
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                pencere.dismiss();
            }
        });

        build.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface pencere, int which) {
                pencere.dismiss();
                finish();
            }

        });
        build.show();
    }
}