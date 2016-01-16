package com.stivinsonmartinez.lamejorruta;


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
public class Tarifas extends Fragment {

    public Tarifas() {        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tarifas, null);

        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;

    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = {"Univiaje", "2", "3", "4"};
        private Integer[] imagen={R.drawable.bus48,R.drawable.bike15};

        public Integer getImagen(Integer i) {
            return imagen[i];
         }

        public void setImagen(Integer[] imagen) {
            this.imagen = imagen;
        }

        private String[][] children = {
                {"Frecuente", "Adulto Mayor", "Estudiante Metro", "PMR", "Al portador"},
                {"Frecuente", "Adulto Mayor", "Estudiante Metro", "PMR", "Al portador"},
                {"Frecuente", "Adulto Mayor", "Estudiante Metro", "PMR", "Al portador"},
                {"Frecuente", "Adulto Mayor", "Estudiante Metro", "PMR", "Al portador"}
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

        public TextView getText2(){
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 64);

            TextView textView = new TextView(Tarifas.this.getActivity());
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
           // AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
            /*TextView textView = new TextView(Tarifas.this.getActivity());

            textView.setGravity(Gravity.RIGHT);
            textView.setTextSize(25);
            textView.setTextColor(R.color.red);
            textView.setPadding(36, 0, 0, 0);
            textView.setText(getGroup(i).toString());
            return textView;*/
            Custom custom = new Custom(Tarifas.this.getActivity(), (String) getGroup(i),R.drawable.bike15,R.drawable.vacia,R.drawable.vacia,R.drawable.vacia,R.drawable.vacia,R.drawable.vacia,R.drawable.vacia);
            return custom.getView();
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(Tarifas.this.getActivity());
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