package com.h5170062.kadir_enes_isler_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BilimAdamlari {
    @SerializedName("Adi Soyadi")
    @Expose
    private String adiSoyadi;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("IlgiAlani")
    @Expose
    private String ilgiAlani;
    @SerializedName("ResimURL")
    @Expose
    private String resimURL;
    @SerializedName("KapakURL")
    @Expose
    private String kapakURL;
    @SerializedName("Detay")
    @Expose
    private String detay;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getIlgiAlani() {
        return ilgiAlani;
    }

    public void setIlgiAlani(String ilgiAlani) {
        this.ilgiAlani = ilgiAlani;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }

    public String getKapakURL() {
        return kapakURL;
    }

    public void setKapakURL(String kapakURL) {
        this.kapakURL = kapakURL;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }
}
