package com.example.pawan.newsexpert;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    MyAdapter myAdapter;
    TabLayout tabLayout;

    public class MyAdapter extends FragmentPagerAdapter
    {
        String [] arr = {"News HeadLine","Politics","Sports","Bollywood","International"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                NewsHeadLineFragment newsHeadLineFragment = new NewsHeadLineFragment();
                return newsHeadLineFragment;

                case 1:
                    PoliticsFragment politicsFragment = new PoliticsFragment();
                    return politicsFragment;

                case 2:
                    SportsFragment sportsFragment = new SportsFragment();
                    return sportsFragment;

                case 3:
                    BollywoodFragment bollywoodFragment = new BollywoodFragment();
                    return bollywoodFragment;

                case 4:
                    InternationalFragment internationalFragment = new InternationalFragment();
                    return internationalFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return arr.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arr[position];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.SecondActivityViewPager);
        tabLayout = (TabLayout) findViewById(R.id.SecondActivityTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_english) {
            Toast.makeText(getApplicationContext(),"English is selected",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_hindi) {
            Toast.makeText(getApplicationContext(),"Hindi is selected",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_kanada) {
            Toast.makeText(getApplicationContext(),"Kanada is selected",Toast.LENGTH_SHORT).show();

        }  else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(),"Share is clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(),"Send is clicked",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
