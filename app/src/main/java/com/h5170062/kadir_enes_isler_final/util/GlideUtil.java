package com.h5170062.kadir_enes_isler_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5170062.kadir_enes_isler_final.R;

public class GlideUtil {
    public static void resmiIndirGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.arka)
                .centerCrop()
                .into(img);
    }
}
