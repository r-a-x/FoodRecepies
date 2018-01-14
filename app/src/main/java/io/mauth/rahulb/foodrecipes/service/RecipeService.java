package io.mauth.rahulb.foodrecipes.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

/**
 * Created by rahulb on 4/11/17.
 */

public class RecipeService {

    private static final String host = "http://35.202.86.142:8080";
    private static final String RECIPE_PATH = "/recipe";

    private Context context;
    private Singleton singleton;

    public RecipeService(Context context) {
        this.context = context;
        singleton = Singleton.getInstance(context);
    }

//    public void postAudits(String androidId, ProductAuditRequest productAuditRequest,
//                           Response.Listener<JSONArray> listener,
//                           Response.ErrorListener errorListener) throws JSONException {
//
//        String url = host  + RECIPE_PATH;
//        String request =  Util.getJson(productAuditRequest,ProductAuditRequest.class) ;
//        CustomJSONArrayRequest jsonArrayRequest = new CustomJSONArrayRequest(Request.Method.POST,url,request,listener,errorListener);
//        singleton.addToRequestQueue(jsonArrayRequest);
//
//    }


    public void getRecipe(Response.Listener<JSONArray> listener,
                          Response.ErrorListener errorListener){

        String url = host  + RECIPE_PATH;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null ,
                listener,errorListener);
        singleton.addToRequestQueue(jsonArrayRequest);
    }
}
