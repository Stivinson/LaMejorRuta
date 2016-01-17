package com.stivinsonmartinez.lamejorruta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Query;
import com.firebase.client.Transaction;
import com.firebase.client.ValueEventListener;

public class NoticiasActivity extends AppCompatActivity {

    private TextView noticias1;
    private TextView noticias2;
    private TextView noticias3;
    private TextView noticias4;
    private String noticias[]={"","","","prueba"};
    private int i=0;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        noticias1 = (TextView) findViewById(R.id.tv_noticia1);
        noticias2 = (TextView) findViewById(R.id.tv_noticia2);
        noticias3 = (TextView) findViewById(R.id.tv_noticia3);
        noticias4 = (TextView) findViewById(R.id.tv_noticia4);

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://enruta.firebaseio.com/");
            Firebase rutas1 = mRef.child("noticia1");
            rutas1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    noticias[0] = snapshot.getValue().toString();
                    noticias1.setText(noticias[0]);
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }

            });

        Firebase rutas2 = mRef.child("noticia2");
        rutas2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                noticias[1] = snapshot.getValue().toString();
                noticias2.setText(noticias[1]);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        Firebase rutas3 = mRef.child("noticia3");
        rutas3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                noticias[2] = snapshot.getValue().toString();
                noticias3.setText(noticias[2]);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        Firebase rutas4 = mRef.child("noticia4");
        rutas4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                noticias[3] = snapshot.getValue().toString();
                noticias4.setText(noticias[3]);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        }
}
