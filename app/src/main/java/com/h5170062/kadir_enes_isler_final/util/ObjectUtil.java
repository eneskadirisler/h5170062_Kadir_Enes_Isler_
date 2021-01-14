package com.h5170062.kadir_enes_isler_final.util;

import com.google.gson.Gson;
import com.h5170062.kadir_enes_isler_final.model.BilimAdamlari;

public class ObjectUtil {
    public static String bilimadamiToJsonString(BilimAdamlari bilimAdamlari)
    {
        Gson gson = new Gson();
        return gson.toJson(bilimAdamlari);
    }
    public static BilimAdamlari jsonStringtoBilimAdamlari(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,BilimAdamlari.class);
    }
}
