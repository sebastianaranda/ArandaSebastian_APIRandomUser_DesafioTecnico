package com.arandasebastian.fluxit_desafiotecnico.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements UsersListFragment.FragmentUserListener, NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = findViewById(R.id.main_activity_drawer_layout);
        NavigationView navigationView = findViewById(R.id.main_activity_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.txt_drawer_open,R.string.txt_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        attachFragment(new UsersListFragment());
    }

    private void attachFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_fragment_container,fragment)
                .commit();
    }

    @Override
    public void receiveUser(User user) {
        Intent intent = new Intent(MainActivity.this,UserProfileActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(UserProfileActivity.KEY_USER,user);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

}
