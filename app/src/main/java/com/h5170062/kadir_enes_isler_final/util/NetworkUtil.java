package com.h5170062.kadir_enes_isler_final.util;

import android.net.ConnectivityManager;
import android.content.Context;
import android.net.NetworkInfo;

public class NetworkUtil {

    public static  boolean internetKontrol(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected())
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

}
