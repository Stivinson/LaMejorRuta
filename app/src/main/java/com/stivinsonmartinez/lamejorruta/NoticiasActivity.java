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

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    /*private Lista_Menu[] newss={
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
            new Lista_Menu(R.drawable.noticias,"Acerca de ..."),};*/

    private String noticias[]={"","","","","",""};
    //private String news="";
    private int i=0;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        /*Adapter adapter = new Adapter(this,newss);
        listnews = (ListView)findViewById(R.id.listnews);
        listnews.setAdapter(adapter);*/
        //final TextView fff = (TextView)findViewById(R.id.fff);
        tv1 = (TextView)findViewById(R.id.tv_noticia1);
        tv2 = (TextView)findViewById(R.id.tv_noticia2);
        tv3 = (TextView)findViewById(R.id.tv_noticia3);
        tv4 = (TextView)findViewById(R.id.tv_noticia4);
        tv5 = (TextView)findViewById(R.id.tv_noticia5);
        tv6 = (TextView)findViewById(R.id.tv_noticia6);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://enruta.firebaseio.com/");
        Firebase rutas1 = mRef.child("noticia1");

        /*for(int i=0;i<6;i++){
            newss[i].setOpcion(noticias[i]);
        }*/
        rutas1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                noticias[0]=(String) tv1.getText();
                noticias[1]=(String) tv2.getText();
                noticias[2]=(String) tv3.getText();
                noticias[3]=(String) tv4.getText();
                noticias[4]=(String) tv5.getText();
                noticias[5]= snapshot.getValue().toString();
                if(noticias[0]!=noticias[5]){
                    tv1.setText(noticias[5]);
                    tv2.setText(noticias[0]);
                    tv3.setText(noticias[1]);
                    tv4.setText(noticias[2]);
                    tv5.setText(noticias[3]);
                    tv6.setText(noticias[4]);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(NoticiasActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tv1", tv1.getText().toString());
        outState.putString("tv2",tv2.getText().toString());
        outState.putString("tv3",tv3.getText().toString());
        outState.putString("tv4",tv4.getText().toString());
        outState.putString("tv5",tv5.getText().toString());
        outState.putString("tv6",tv6.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText(savedInstanceState.getString("tv2"));
        tv3.setText(savedInstanceState.getString("tv3"));
        tv4.setText(savedInstanceState.getString("tv4"));
        tv5.setText(savedInstanceState.getString("tv5"));
        tv6.setText(savedInstanceState.getString("tv6"));
    }
}
