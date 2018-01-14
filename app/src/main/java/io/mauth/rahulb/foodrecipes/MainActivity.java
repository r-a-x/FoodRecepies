package io.mauth.rahulb.foodrecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

import io.mauth.rahulb.foodrecipes.model.Recipe;
import io.mauth.rahulb.foodrecipes.response.RecipeResponse;
import io.mauth.rahulb.foodrecipes.util.Util;

public class MainActivity extends AppCompatActivity {

    private Response.ErrorListener errorListener = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("API",error.toString());
            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
        }

    };

    private Response.Listener<JSONArray> response = new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            try {

                Type token = new TypeToken<List<RecipeResponse>>() {}.getType();
                List<RecipeResponse> products = Util.gson.fromJson(response.toString(),token);
                initRecipeView(products);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private void initRecipeView(List<RecipeResponse> recipeResponses){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
