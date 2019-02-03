package com.example.introduccion.recyclerview.sevenwonders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.introduccion.recyclerview.sevenwonders.Adapters.WondersAdapter;
import com.example.introduccion.recyclerview.sevenwonders.Models.Wonders;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String jsonUrl = "https://raw.githubusercontent.com/DouglasMoran/DSM_Complementario2/master/wonders.json";
    private ArrayList<Wonders> wonders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadContent();
    }


    public void loadContent(){
        RequestQueue resRequestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(jsonUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    parseContent(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Ocurrio un error al cargar los recursos. Conectarse a la red.",Toast.LENGTH_SHORT).show();
            }
        });

        resRequestQueue.add(jsonArrayRequest);

    }

    private void parseContent(JSONArray jsonArray) throws JSONException {

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject tmp = jsonArray.getJSONObject(i);
            Gson gson =  new Gson();
            Wonders wonder = gson.fromJson(tmp.toString(),Wonders.class);
            wonders.add(wonder);
        }

        RecyclerView recyclerView = findViewById(R.id.wondersRecyclerView);
        recyclerView.setAdapter(new WondersAdapter(this, wonders));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
