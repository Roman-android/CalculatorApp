package ru.roman.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ru.roman.calculatorapp.fragmentsNavigation.AboutFragment;
import ru.roman.calculatorapp.fragmentsNavigation.LevelFragment_1;
import ru.roman.calculatorapp.fragmentsNavigation.ListMain;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ListMain.OnLinkItemSelectedListenerMain,LevelFragment_1.OnLinkItemSelectedListenerUnder {

    private final String MY_LOG = "myFilterMain";
    public ActionBarDrawerToggle toggle;
    public DrawerLayout drawer;
    public Toolbar toolbar;
    public FloatingActionButton fab;
    ListMain listMain;
    LevelFragment_1 levelFragment_1;
    ViewPagerWorkFragment viewPagerWorkFragment;
    FragmentManager fragmentManager;
    AboutFragment aboutFragment;
    int numListMain;
    ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addDrawerListener(toggle);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // TODO: 15.04.2017 Подключаем фрагменты
        listMain = new ListMain();
        aboutFragment = new AboutFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, listMain, null).commit();
    }

    public void setDrawerOnIcon(boolean isEnabled) {
        setSupportActionBar(toolbar);
        if (isEnabled) {
            toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setHomeButtonEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setDisplayShowHomeEnabled(false);
            }
            toggle.setDrawerIndicatorEnabled(true);
        } else {
            toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
            toggle.setDrawerIndicatorEnabled(false);
        }
        toggle.syncState();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    // TODO: 09.05.2017 Показ меню с 3 точками
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_settings);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //shareActionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
        shareActionProvider.setShareIntent(createShareIntent());

        return true;
    }

    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "http://e1.ru");
        Intent choseIntent = Intent.createChooser(shareIntent, "Заголовок");
        //return shareIntent;
        return choseIntent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            fragmentManager.popBackStack();
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentTransaction ftrans = fragmentManager.beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            if (!listMain.isAdded()) {
                //setDrawerOnIcon(false);
                ftrans.replace(R.id.container, listMain, null).addToBackStack(null);
                Log.d(MY_LOG, "isNoAdded");
            }

        } else if (id == R.id.nav_gallery) {
            if (!aboutFragment.isAdded()){
                //setDrawerOnIcon(false);
                ftrans.replace(R.id.container, aboutFragment, null).addToBackStack(null);
            }
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }ftrans.commit();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void OnItemSelectedMain(int num, String selection) {
        numListMain = num;
        levelFragment_1 = LevelFragment_1.newInstance(num, selection);
        fragmentManager.beginTransaction().replace(R.id.container, levelFragment_1, null).addToBackStack(null).commit();
    }

    @Override
    public void onItemSelectedUnder(int itemPosition,String selection) {
        viewPagerWorkFragment = ViewPagerWorkFragment.newInstance(numListMain,itemPosition,selection);
        fragmentManager.beginTransaction().replace(R.id.container,viewPagerWorkFragment,null).addToBackStack(null).commit();
        fab.setVisibility(View.GONE);
    }
}