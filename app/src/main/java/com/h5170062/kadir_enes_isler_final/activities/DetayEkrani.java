package com.h5170062.kadir_enes_isler_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5170062.kadir_enes_isler_final.R;
import com.h5170062.kadir_enes_isler_final.model.BilimAdamlari;
import com.h5170062.kadir_enes_isler_final.util.Constants;
import com.h5170062.kadir_enes_isler_final.util.GlideUtil;
import com.h5170062.kadir_enes_isler_final.util.ObjectUtil;

public class DetayEkrani extends AppCompatActivity {


    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay_ekrani);
        init();
    }
    private void init()
    {

        String tasinanBilimAdamiString = getIntent().getStringExtra(Constants.TIKLANAN_BILIM_ADAMI_BASLIGI);
        BilimAdamlari bilimAdamlari = ObjectUtil.jsonStringtoBilimAdamlari(tasinanBilimAdamiString);
        imgKapak = findViewById(R.id.imgKapakFoto);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);
        txtBaslik.setText(bilimAdamlari.getAdiSoyadi());
        txtDetay.setText(bilimAdamlari.getDetay());

        GlideUtil.resmiIndirGoster(getApplicationContext(),bilimAdamlari.getKapakURL(),imgKapak);
    }
}