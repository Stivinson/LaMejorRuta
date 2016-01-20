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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    ListView listMenu;
    int opc=0;
    private Lista_Menu[] menu=
            new Lista_Menu[]{
                    new Lista_Menu(R.drawable.metro,"Acerca de ..."),
                    new Lista_Menu(R.drawable.bus48,"Acerca de ..."),
                    new Lista_Menu(R.drawable.encicla,"Acerca de ..."),
                    new Lista_Menu(R.drawable.noticias,"Acerca de ..."),
                    new Lista_Menu(R.drawable.informacion,"Acerca de ...")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter=new Adapter(this,menu);
        listMenu=(ListView)findViewById(R.id.listview);
        listMenu.setAdapter(adapter);
        String[] value=getResources().getStringArray(R.array.Menu);
        Firebase.setAndroidContext(this);
        Firebase mRef = new Firebase("https://enruta.firebaseio.com/");
        final Firebase encicla = mRef.child("ENCICLA");
        for(int i=0;i<5;i++){
            menu[i].setOpcion(value[i]);
        }
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
                        encicla.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String mapURL =dataSnapshot.getValue().toString();
                                Intent intent = new Intent(getApplicationContext(), MapViewActivity.class);
                                intent.putExtra("Url",mapURL);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {
                                Toast.makeText(MainActivity.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), NoticiasActivity.class));
                        break;
                    case 4:
                       // startActivity(new Intent(getApplicationContext(), pizzabar.class));
                        startActivity(new Intent(getApplicationContext(), About.class));
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
