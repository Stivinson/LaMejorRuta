package com.stivinsonmartinez.lamejorruta;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class Metro extends AppCompatActivity implements ActionBar.TabListener,ViewPager.OnPageChangeListener{

    private ViewPager MetroViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro);

        MetroPager adapter = new MetroPager(getSupportFragmentManager());
        MetroViewer = (ViewPager) findViewById(R.id.metropager);
        MetroViewer.setAdapter(adapter);
        MetroViewer.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Lineas Metro").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setIcon(R.drawable.dollar178).setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setIcon(R.drawable.road41).setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setIcon(R.drawable.road41).setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setIcon(R.drawable.logoenruta).setTabListener(this);
        actionBar.addTab(tab);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MetroViewer.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    public class MetroPager extends FragmentPagerAdapter{

        public MetroPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new LineaTrans();
                   case 1:
                    return new Tarifas();
                case 2:
                    return new Horarios();
                case 3:
                    return new Estaciones();
                case 4:
                    return new ContactoMetro();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
