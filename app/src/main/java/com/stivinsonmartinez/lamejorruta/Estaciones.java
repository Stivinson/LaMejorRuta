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
                                   "Caribe","Catedral Metropolitana","Chagualo","Cisneros","Envigado","Esatdio","Exposiciones","Floresta","Fatima","Gardel","Hospital",
                                    "Industriales","Itagui","Juan XXIII","La Aurora","La Estrella","La Palma","La Playa","Las Esmeraldas","Los Alpes","Madera","Manrique","Minorista",
                                    "Niquia","Nutibara","Palos Verdes","Parque Aranjuez","Parque Belen","Parque Berrio","Plaza Mayor","Poblado","Popular","Prado","Rosales","Ruta N-U. de A.",
                                    "Sabaneta","San Antonio","San Javier","San Jose","Santa Lucia","Santo Domingo","Suramericana","Tricentenario","U. de M.","Universidad","Vallejuelos"};


        private String[][] children = {
                {getString(R.string.intgr),"207I Boyaca las brisas","2831 Florencia-Barrio nuevo","C6-001 Santa Rita-Zamora-Acevedo" },
                {getString(R.string.intgr),"132I La Visitacion, CC Oviedo, EAFIT ","133I Club Campestre,ISA, Loma de los Gonzales","133IA Los Balsos, La visitacion, La Y","135I Aguacatala, Av.Poblado, Cl 20A Sur","1431 Barrio La Colonia, San Rafael, FLA","C3-001 Aguacatala - Industriales","C3-003  Aguacatala - Bulerias"},
                {getString(R.string.intgr),"C6-010 Villatina-Alpujarra" },
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"6380 Ayura-San Mateo","6402-1 San Lucas 1","6405 Altos de Misael A y B","C-ITA Circular Itagui"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"1006 Quinta Etapa","1010 San Martin","1011 Pachelly Parque","1012 Tierradentro","1013 Villa Linda","1020 Cumbre-Carmelo","1022 Barrio Perez-Comfama","1023 Santa Ana-Bucaros","1024 Trapiche-Valadares","1025 Vereda Perez-Rosalpi-Hatoviejo","1027 Mirador-Congolo","POTRERITO Vereda Potrerito","TRAPICHE-PEÑA VERDE"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"6402-2 San Lucas 2","6403 Loma del Chocho","6404 Loma del Escobero-Farolito","6406 El Salado","6407 El Dorado-San Juan-Mangazul","6408 San Rafael-La Mina","6410 Chingui","ALTO DE LAS FLORES","ARENALES","CALATRAVA","PALMAS"},
                {getString(R.string.intgr),"193I UPB - Unicentro - Glorieta Bulerias - Bomba Los Almendros","193II Estadio - Carrera 70 - Calle 35 - Calle 33 - Carrera 81"},
                {getString(R.string.intgr),"C6-004 Milagrosa - Exposiciones"},
                {getString(R.string.intgr),"246I Blanquizal","250I Urbanizacion SAnta Clara - Urbanizacion Mirador de Robledo"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"C6-019 Raizal - Gardel","C6-022 La Cruz - Gardel"},
                {getString(R.string.intgr),"254I Picachito - Terminal del Norte - Hospital","C6-002 Villahermosa - Hospital","C6-003 Campo Valdez - Hopital","C6-016 Nuevo Horizonte - Hospital"},
                {getString(R.string.intgr),"136I Chuscalito - Av. Las Palmas - Av.Poblado - Carrera 43F - Industriales","C3-001 Aguacatala - Industriales"},
                {getString(R.string.intgr),"317 Barichara - Limonar","5420 San Francisco","5422 San Francisco","5423 Cedros de Badajoz - Yarumito","6420 Señorial - Trianon","7423 Lomitas","C-SAB-1 La Doctora","EL AJIZAL","ESTRELLA7 Estrella ruta 7 - Fererria - Metro Itagui"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"250II La Aurora - Las Hamacas - Pajarito","250III Aurora - Tulipanes - La Huerta","C23II San Cristobal - Estacion La Aurora"},
                {getString(R.string.intgr),"318I Prado - La Estrella", "7420 Cañaveralejo","7421 Pan de Azucar","9420 Caldas - La Estrella - La 50","9420 Caldas - La Miel - La variante","9420 Caldas - La Tablaza - La Variante","9422 Caldas - Los Lagos - La 50","9422 Caldas - Parque - La 50","ESTRELLA3 La estrella ruta 3 - Comfama Metro","ESTRELLA5 Estrella ruta 5 - Comfama Metro","ESTRELLA7A Estrella ruta 7E - Ferreria Metro - La Estrella","PUEBLO VIEJO - METRO","SANJOSE  San Jose - Sabaneta"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"C6-015 Granizal - Esmeraldas"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"1040 Cabañas - Barrio Obrero","1041 Cabañas - Amaru - Barrio Nuevo","1042 Paris - Los Sauces","1043 Machado - Parque de Bello","1045 Villas de Occidente","2002 Copacabana por Machado"},
                {getString(R.string.intgr),"C6-020 San Jose de la Cima - Universidad"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"1001 Niquia Quitasol","1002 Niquia Camacol la 65","1003 Navarra - Parque","1004 Niquia - Maximiliano - Kolbe","1005 Niquia Camacol la 61","1008 San Martin - Bellavista","1014 San Felix","2001 Copacabana x Autopista, Cando","2001-1 Copacabana - Piscina","2001-2 Copacabana - San Juan","3001 Girardota","4001-1 Barbosa","4001-2 Barbosa - Parque de las Aguas","C-2000-1 Circular 2000-1","C-2000-2 Circular 2000-2","TERRANOVA"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"C6-016 Nuevo Horizonte - San Antonio"},
                {getString(R.string.intgr),"C6-011 Santa Cruz - Aranjuez","C6-012 La Francia - Aranjuez","C6-013 Aranjuez - Tricentenario","C6-017 Santa Cecilia#2 - Aranjuez","C6-018 Santa Cecilia#1 - Aranjuez","C6-021 Granizal - Aranjuez"},
                {getString(R.string.intgr),"C3-003 Belen - Manzanillo Belen - La Piscina"},
                {getString(R.string.intgr),"C6-006 Caicedo - Berrio","C6-008 La Libertad - Berrio"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"133I San Lucas","134I Calle 10 - Loma el Tesoro","134II Calle 10 - Transversal Superior - CES - Marianito - Las Palmas - Colegiatura"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"C6-009 Enciso - Prado"},
                {getString(R.string.intgr),"C3-002 Aguacatala - Bulerias"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"318 San Antonio de Prado - Compartir - Pradito - El Descanso","319 San Antonio de Prado - El Vergel","7422 Maria Auxiliadora","AVES MARIA","CASIMBAS","INMACULADA","SANTA MARIA LA NUEVA - OLIVARES - ZULETA","VILLA LIA - SANTANA - SAN PIO"},
                {getString(R.string.intgr),"C6-005 Bombona - San Antonio","C6-005A Quinta Linda - San Antonio","C6-007 Buenos Aires - San Antonio"},
                {getString(R.string.intgr),"201I Belencito - Corazon","221I Belencito - Villa Laura","225I 20 de Julio","226I Barrio el Salado - Deposito","227I Barrio Eduardo Santos","227IA Las Peñitas","227IB La Gabriela","228I Nuevos Conquistadores","243ID La Divisa","C23I San Cristobal","C23II San Cristobal"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"195I Simon Bolivar - Unicentro","202I LA America, Santa Monica","243I Barrio la Divisa - Barrio la Quiebra - Barrio Metropolitano","311I Calazans","311II Calazania - Campo Verde - Santa Lucia"},
                {getString(R.string.intgr),"No tiene rutas integradas"},
                {getString(R.string.intgr),"253I Robledo Aures"},
                {getString(R.string.intgr),"263I Doce Octubre","C6-013 Aranjuez Anillo - Tricentenario","C6-018 Santa Cecilia#2 - Tricentenario"},
                {getString(R.string.intgr),"C3-004 Altavista - Buga - La Perla","C3-005 Aguasfrias","C3-006 Las Violetas - Villa Cafe"},
                {getString(R.string.intgr),"261I DERECHA Castilla - Alfonso Lopez - Francisco Zea","261I IZQUIERDA Terminal Norte - Alfonso Lopez - Carrera 65","C6-020 San Jose de la Cima - Universidad"},
                {getString(R.string.intgr),"No tiene rutas integradas"}

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