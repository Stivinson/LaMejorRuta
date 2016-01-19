package com.stivinsonmartinez.lamejorruta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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
    //private Firebase rutas1;
    private ListView listnews;

    private Lista_Menu[] newss={
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),};

    private String noticias[]={"","","","","",""};
    //private String news="";
    private int i=0;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        Adapter adapter = new Adapter(this,newss);
        listnews = (ListView)findViewById(R.id.listnews);
        listnews.setAdapter(adapter);
        final TextView fff = (TextView)findViewById(R.id.fff);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://enruta.firebaseio.com/");
        Firebase rutas1 = mRef.child("noticia1");

        for(int i=0;i<6;i++){
            newss[i].setOpcion(noticias[i]);
        }
        rutas1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //noticias[0] = snapshot.getValue().toString();
                //noticias1.setText(noticias[0]);
                    /*noticias[0]= (String) noticias1.getText();
                    noticias[1]= (String) noticias2.getText();
                    noticias[2]= (String) noticias3.getText();
                    noticias[3]= snapshot.getValue().toString();
                    noticias1.setText(noticias[3]);
                    noticias2.setText(noticias[0]);
                    noticias3.setText(noticias[1]);
                    noticias4.setText(noticias[2]);*/
                for(int i=0;i<5;i++){
                    noticias[i] = newss[i+1].getOpcion();
                }
                noticias[5] = snapshot.getValue().toString();
                newss[1].setOpcion(noticias[5]);
                for(int i=0;i<5;i++){
                    newss[i+1].setOpcion(noticias[i]);
                }
                fff.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public class Adapter extends ArrayAdapter<Lista_Menu> {

        public Adapter(Context context, Lista_Menu[] datos) {
            super(context, R.layout.activity_main, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_main2, null);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(newss[position].getIdImagen());
            TextView informacion = (TextView) item.findViewById(R.id.tinformacion);
            informacion.setText(newss[position].getOpcion());

            return item;
        }
    }
}
