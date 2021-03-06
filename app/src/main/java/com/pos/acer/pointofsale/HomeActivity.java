package com.pos.acer.pointofsale;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DatabaseManager databaseManager;
    private Toolbar toolbar;
    private ImageHelper imageHelper;
    private ImageView tvImage;
    private TextView tvUsername;
    private TextView tvEmail;
    private User users;
    private Button btnLogout;
    private int activeFragment = 0;
    private final static int homeFragment = 0;
    private final static int userFragment = 1;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        databaseManager = new DatabaseManager(this);
        imageHelper = new ImageHelper(getApplicationContext(),HomeActivity.this);
        View header = navigationView.getHeaderView(0);

        tvUsername = (TextView) header.findViewById(R.id.userName);
        tvEmail = (TextView) header.findViewById(R.id.userEmail);
        tvImage = (ImageView) header.findViewById(R.id.userImage);
        btnLogout = (Button) header.findViewById(R.id.btnLogOut);
        btnLogout.setOnClickListener(this);
        IntentObject object = new IntentObject();
        Bundle bundle = getIntent().getExtras();
        users = object.getUserFromIntent(bundle);
        if (users != null){
            tvUsername.setText(users.getFullname());
            tvEmail.setText(users.getEmail());
            role = users.getRole();
            tvImage.setImageBitmap(imageHelper.getUserProfile(users.getImgProfile()));
        }
        if (!role.equals("admin")) {
            navigationView.getMenu().findItem(R.id.nav_users).setVisible(false);
        }
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_home) {
            Fragment(homeFragment);
        } else if (id == R.id.nav_product) {

        } else if (id == R.id.nav_promotions) {

        } else if (id == R.id.nav_record) {

        } else if (id == R.id.nav_users) {
            Fragment(userFragment);
        } else if (id == R.id.nav_setting) {

        }else if (id == R.id.nav_sync) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenHome, fragment).commit();
    }
    private  void Fragment(int position){
        activeFragment = position;
        Fragment fragment = null;
        switch (position){
            case homeFragment : fragment = new FragmentHome();
//                                toolbar.setTitle(R.string.User);
                                break;
            case userFragment : fragment = new FragmentUser();
//                                toolbar.setTitle(R.string.User);
                break;
            default                 :   break;
        }
        if(fragment != null){
            setFragment(fragment);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnLogOut)
        {
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }
}
