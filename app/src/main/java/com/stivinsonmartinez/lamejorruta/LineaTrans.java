package com.stivinsonmartinez.lamejorruta;


import android.app.ListFragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Query;
import com.firebase.client.Transaction;
import com.firebase.client.ValueEventListener;

import java.net.URL;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LineaTrans extends Fragment {
    ListView listMenu;
    String selection;
    int opc=0;
    private Firebase mRef;
    final String[] datos = new String[]{"Linea A", "Linea B", "Linea K","Linea L", "Linea J", "Linea 1 de buses","Linea 2 de buses"};
    public LineaTrans() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //firebase
        Firebase.setAndroidContext(LineaTrans.this.getActivity());
        mRef= new Firebase("https://enruta.firebaseio.com/");

        View rootView = inflater.inflate(R.layout.fragment_linea_trans, container, false);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datos);
        listMenu=(ListView) rootView.findViewById(R.id.listview2);
        listMenu.setAdapter(adaptador);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                opc=(int)parent.getItemIdAtPosition(position);
                switch (opc){
                    case 0:
                        selection="Linea A";
                        break;
                    case 1:
                        selection="Linea B";
                        break;
                    case 2:
                        selection="Linea K";
                        break;
                    case 3:
                        selection="Linea L";
                        break;
                    case 4:
                        selection="Linea J";
                        break;
                    case 5:
                        selection="Linea 1";
                        break;
                    case 7:
                        selection="Linea 2";
                        break;
                    default:
                        break;
                }


                Firebase rutas = mRef.child(selection);
                rutas.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // Toast.makeText(RutasMedellin.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                        String mapURL =snapshot.getValue().toString();
                       // Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(mapURL));
                        Intent intent = new Intent(LineaTrans.this.getActivity(),MapViewActivity.class);
                        intent.putExtra("Url",mapURL);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Toast.makeText(LineaTrans.this.getActivity(), "Lectura fallida: " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return rootView;

    }


}