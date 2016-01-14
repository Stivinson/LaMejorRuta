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

import java.net.URL;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LineaTrans extends Fragment {
    ListView listMenu;
    int opc=0;



/*private String[] lineasM;


    public LineaTrans() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_linea_trans,container,false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        lineasM=getResources().getStringArray(R.array.Lineas);
        Toast.makeText(getActivity(), "Ha pulsado"+lineasM[position],Toast.LENGTH_SHORT).show();
        int opc=position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        lineasM=getResources().getStringArray(R.array.Lineas);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,lineasM));
    }*/

    //CRIDA LA LLISTA I LA FUNCIO DE LISTVIEW
    final String[] datos = new String[]{"Linea A", "Linea B", "Linea K","Linea L", "Linea J", "Linea 1 de buses","Linea 2 de buses"};

    public LineaTrans() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), MapsActivity.class));
                        break;
                    case 2:
                        String mapURL = "https://www.google.com.co/maps/@6.2558089,-75.5844522,13.76z/data=!4m2!6m1!1szrEAbgXNHZ9Y.kI8HwmC3rr6M?hl=es";
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(mapURL));
                        startActivity(intent);
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        break;
                }

            }
        });
        return rootView;

    }


}