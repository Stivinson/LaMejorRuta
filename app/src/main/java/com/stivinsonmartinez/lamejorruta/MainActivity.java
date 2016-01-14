package com.stivinsonmartinez.lamejorruta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class MainActivity extends AppCompatActivity {
    //private Firebase mRef;
    ListView listMenu;
    int opc=0;
    private Lista_Menu[] menu=
            new Lista_Menu[]{
                    new Lista_Menu(R.drawable.underground,"Sistema Metro"),
                    new Lista_Menu(R.drawable.bus48,"Rutas medellin"),
                    new Lista_Menu(R.drawable.bike15,"Encicla"),
                    new Lista_Menu(R.drawable.globe_50,"Noticias"),
                    new Lista_Menu(R.drawable.globe_50,"Acerca de ...")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase
       /* Firebase.setAndroidContext(this);
        mRef= new Firebase("https://enruta.firebaseio.com/");

        //Lectura de informacion Metodo1

        Firebase ruta = mRef.child("ruta300");
        ruta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Toast.makeText(MainActivity.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(MainActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/


        Adapter adapter=new Adapter(this,menu);
        listMenu=(ListView)findViewById(R.id.listview);
        listMenu.setAdapter(adapter);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                opc = (int) parent.getItemIdAtPosition(position);
                switch (opc) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Metro.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), RutasMedellin.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        break;
                    case 3:

                        break;
                    case 4:
                       // startActivity(new Intent(getApplicationContext(), pizzabar.class));
                        break;
                    default:
                        break;
                }

            }
        });

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
            imagen.setImageResource(menu[position].getIdImagen());

            TextView informacion = (TextView) item.findViewById(R.id.tinformacion);
            informacion.setText(menu[position].getOpcion());

            return item;
        }
    }
}
