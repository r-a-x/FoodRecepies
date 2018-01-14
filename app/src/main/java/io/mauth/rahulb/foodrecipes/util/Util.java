package io.mauth.rahulb.foodrecipes.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by rahulb on 7/11/17.
 */

public final class Util {

    public static Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static Date getDate(String epoch){
        Long seconds = Long.parseLong(epoch);
        return new Date(seconds*1000L);
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String toBase64(byte[]  bytes){
        return  new String (Base64.encode(bytes,0) );
    }

    public static String getJson(Object object,Class cl){

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        return gson.toJson(object,cl);

    }

    public static Bitmap base64ToBitmap(String base64){

        if ( base64 == null)
            return null;
        byte[] byteArray = Base64.decode(base64,0);
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return bmp;

    }

    public static <T> List<T> getListFromJSON(T t,String json ){


        TypeToken<List<T>> token = new TypeToken<List<T>>() {};
        List<T> lists = gson.fromJson(json.toString(), token.getType());

        return lists;

    }


    public static String androidId(Activity activity){
        return Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}
