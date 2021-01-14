package com.h5170062.kadir_enes_isler_final.network;

import com.h5170062.kadir_enes_isler_final.model.BilimAdamlari;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;


public interface ServiceApi {

    @GET("liste.json")
    Observable<List<BilimAdamlari>> bilimadamlariGetir();

}
