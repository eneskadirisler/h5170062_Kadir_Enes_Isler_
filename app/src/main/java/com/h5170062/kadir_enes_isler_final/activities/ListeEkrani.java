package com.h5170062.kadir_enes_isler_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.cagataymuhammet.objectprinter.ObjectPrinter;
import com.h5170062.kadir_enes_isler_final.R;
import com.h5170062.kadir_enes_isler_final.adapter.BilimAdamiAdapter;
import com.h5170062.kadir_enes_isler_final.model.BilimAdamlari;
import com.h5170062.kadir_enes_isler_final.network.Service;
import com.h5170062.kadir_enes_isler_final.util.Constants;
import com.h5170062.kadir_enes_isler_final.util.GlideUtil;
import com.h5170062.kadir_enes_isler_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeEkrani extends AppCompatActivity {

    RecyclerView rcv;
    ImageView imgKapak;
    String resimURL = "https://raw.githubusercontent.com/eneskadirisler/FinalOdevi/main/a1.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_ekrani);
        init();
    }

    @Override
    public void onBackPressed() {
        Dialog();
    }
    private void Dialog()
    {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Çıkış?");
        build.setMessage("Uygulamadan çıkış yapmak istiyormusunuz");
        build.setPositiveButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface pencere, int which) {
                pencere.dismiss();
            }
        });

        build.setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface pencere, int which) {
                pencere.dismiss();
                finish();
            }
        });
        build.show();
    }
    private void init()
    {
        kapakResminiCek();
        bilimadamlariniGetir();
    }
    private void kapakResminiCek()
    {
        imgKapak = findViewById(R.id.imgKapak);
        GlideUtil.resmiIndirGoster(getApplicationContext(),resimURL,imgKapak);
    }
    private void initRecycleView(List<BilimAdamlari> bilimAdamlariList)
    {
        rcv = findViewById(R.id.rcvBilimA);
        BilimAdamiAdapter bilimAdamiAdapter = new BilimAdamiAdapter(bilimAdamlariList, getApplicationContext(), new BilimAdamiAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                BilimAdamlari tiklananBilimAdami = bilimAdamlariList.get(position);
                Toast.makeText(ListeEkrani.this, "Tıklanan Adı :"+tiklananBilimAdami.getAdiSoyadi(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananBilimAdami);
            }
        });
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(bilimAdamiAdapter);
    }
    private void opennextActivity(BilimAdamlari tiklananBilimAdami)
    {
        Log.e("Counter","Finish");
        Intent secondActivityIntent = new Intent(getApplicationContext(),DetayEkrani.class);
        String tiklananBilimAdamiString = ObjectUtil.bilimadamiToJsonString(tiklananBilimAdami);
        secondActivityIntent.putExtra(Constants.TIKLANAN_BILIM_ADAMI_BASLIGI,tiklananBilimAdamiString);
        startActivity(secondActivityIntent);
    }

    void bilimadamlariniGetir()
    {
        new Service().getServiceApi().bilimadamlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BilimAdamlari>>() {

                    List<BilimAdamlari> bilimAdamlari = new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("RETROFIT","onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull List<BilimAdamlari> bilimAdamlarilist) {
                        Log.e("RETROFIT","onNext");
                        bilimAdamlari = bilimAdamlarilist;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("RETROFIT_ERROR","onError"+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete");
                        if(bilimAdamlari.size()>0)
                        {
                            ObjectPrinter.printJson(bilimAdamlari);
                            initRecycleView(bilimAdamlari);
                        }
                    }
                });
    }
}