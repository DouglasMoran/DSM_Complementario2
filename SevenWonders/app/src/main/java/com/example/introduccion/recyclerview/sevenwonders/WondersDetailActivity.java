package com.example.introduccion.recyclerview.sevenwonders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.introduccion.recyclerview.sevenwonders.Models.Wonders;

public class WondersDetailActivity extends AppCompatActivity {

    TextView titulo,mensaje,descripcion,megusta,pais,direccion,horario,correo,telefono,web;
    ImageView imgDetalles;
    ImageView estrella1,estrella2,estrella3,estrella4,estrella5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders_detail);

        getRss();
        loadContent();

    }

    private void getRss(){
        titulo = findViewById(R.id.tituloDetalles);
        mensaje = findViewById(R.id.textoImgsDetalles);
        descripcion = findViewById(R.id.descripcionDetalles);
        megusta = findViewById(R.id.reviewsDetalles);
        pais = findViewById(R.id.paisDetalles);
        direccion = findViewById(R.id.direccionDetalles);
        horario = findViewById(R.id.horariosDetalles);
        correo = findViewById(R.id.emailDetalles);
        telefono = findViewById(R.id.telefonoDetalles);
        web = findViewById(R.id.webDetalles);


        imgDetalles = findViewById(R.id.imgsDetalles);

        estrella1 = findViewById(R.id.estrella1Detalles);
        estrella2 = findViewById(R.id.estrella2Detalles);
        estrella3 = findViewById(R.id.estrella3Detalles);
        estrella4 = findViewById(R.id.estrella4Detalles);
        estrella5 = findViewById(R.id.estrella5Detalles);
    }


    public void loadContent(){


        Intent intent = getIntent();
        Wonders getWonder = intent.getParcelableExtra("detail");

        //load image
        Glide.with(this)
                .load(getWonder.getImgDetails())
                .into(imgDetalles);

        //load strings
        mensaje.setText(getWonder.getMessage());
        titulo.setText(getWonder.getTitle());
        megusta.setText(getWonder.getLikes());
        descripcion.setText(getWonder.getDescription());
        pais.setText(getWonder.getCountry());
        horario.setText(getWonder.getSchedules());
        direccion.setText(getWonder.getAddress());
        correo.setText(getWonder.getMail());
        telefono.setText(getWonder.getPhone());
        web.setText(getWonder.getWebsite());

    }

}
