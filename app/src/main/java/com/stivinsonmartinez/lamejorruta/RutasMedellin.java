package com.stivinsonmartinez.lamejorruta;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Query;
import com.firebase.client.Transaction;
import com.firebase.client.ValueEventListener;

public class RutasMedellin extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Firebase mRef;
    private int posicion;
    private String selection;
    private ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        final Spinner ruta=(Spinner) findViewById(R.id.sp_rutas);
        //ruta.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,valores));
        adapter = ArrayAdapter.createFromResource(this, R.array.Rutas,
                android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        ruta.setAdapter(adapter);
        ruta.setOnItemSelectedListener(this);

        //firebase
        Firebase.setAndroidContext(this);
        mRef= new Firebase("https://enruta.firebaseio.com/");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        posicion = position;
        selection = parent.getItemAtPosition(posicion).toString();
        if(selection.toString().equalsIgnoreCase("")){
            //Toast.makeText(RutasMedellin.this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();

        }else {
            //Toast.makeText(RutasMedellin.this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();
            Firebase rutas = mRef.child(selection);
            rutas.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    // Toast.makeText(RutasMedellin.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                    String mapURL =snapshot.getValue().toString();
                    // Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(mapURL));
                    Intent intent = new Intent(RutasMedellin.this,MapViewActivity.class);
                    intent.putExtra("Url",mapURL);
                    startActivity(intent);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(RutasMedellin.this, "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        //Toast.makeText(RutasMedellin.this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
