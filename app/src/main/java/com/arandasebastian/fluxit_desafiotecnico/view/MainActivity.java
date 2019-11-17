package com.arandasebastian.fluxit_desafiotecnico.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;

public class MainActivity extends AppCompatActivity implements UsersListFragment.FragmentUserListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachFragment(new UsersListFragment());
    }

    private void attachFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_fragment_container,fragment)
                .addToBackStack(null)
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
}
