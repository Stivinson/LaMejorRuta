package com.stivinsonmartinez.lamejorruta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.stivinsonmartinez.lamejorruta.Custom;
import com.stivinsonmartinez.lamejorruta.R;




import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class Estaciones extends Fragment {

    public Estaciones() {        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estaciones, null);

        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list2);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;

    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = {"Acevedo","Aguacatala","Alpujarra","Andalucia","Arvi","Ayura","Barrio Colombia","Barrio colon","Barrio San Diego","Bello","Berlin",
                                   "Caribe","Catedral Metropolitana","Chagualo","Cisneros","Envigado","Esatdio","Exposiciones","Floresta","Fatima","Gardel","Hospital"};


        private String[][] children = {
                {"RUTAS INTEGRADAS","2071 Boyaca las brisas","2831 Florencia-Barrio nuevo","C6-001 Santa Rita-Zamora-Acevedo" },
                {"RUTAS INTEGRADAS","1321 La Visitacion, CC Oviedo, EAFIT ","1331 Club Campestre,ISA, Loma de los Gonzales","1331A Los Balsos, La visitacion, La Y","1351 Aguacatala, Av.Poblado, Cl 20A Sur","1431 Barrio La Colonia, San Rafael, FLA","C3-001 Aguacatala - Industriales","C3-003  Aguacatala - Bulerias"},
                {"RUTAS INTEGRADAS","1321 La Visitacion, CC Oviedo, EAFIT ","1331 Club Campestre,ISA, Loma de los Gonzales"},
                { "Fluffy", "Snuggles" },
                { "Goldy", "Bubbles" }
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        public TextView getText2() {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 64);

            TextView textView = new TextView(Estaciones.this.getActivity());
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setTextSize(20);
            //textView.setTextColor(R.color.aliceblue);
            // Set the text starting position
            textView.setPadding(36, 0, 0, 0);
            return textView;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Estaciones.this.getActivity());
            textView.setTextSize(23);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
            textView.setPadding(36, 0, 0, 0);
            textView.setTextColor(R.color.black);
            textView.setText(getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Estaciones.this.getActivity());
            textView.setTextSize(15);
            textView.setTextColor(R.color.blue);
            textView.setPadding(36, 0, 0, 0);
            textView.setText(getChild(i, i1).toString());
            return textView;
            /*Custom custom = new Custom(Tarifas.this.getActivity(), (String) getChild(i, i1),R.drawable.bike15);
            return custom.getView();*/
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }
}