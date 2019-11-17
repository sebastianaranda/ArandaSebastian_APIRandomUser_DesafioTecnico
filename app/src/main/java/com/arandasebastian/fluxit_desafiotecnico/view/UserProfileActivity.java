package com.arandasebastian.fluxit_desafiotecnico.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.bumptech.glide.Glide;

public class UserProfileActivity extends AppCompatActivity {

    public static final String KEY_USER = "key_user";
    private ImageView imgUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User selectedUser = (User) bundle.getSerializable(KEY_USER);

        imgUser = findViewById(R.id.user_profile_activity_user_image);

        Glide.with(this)
                .load(selectedUser.getPictures().getPictureLarge())
                .placeholder(R.drawable.img_profile_placeholder)
                .into(imgUser);
    }
    
}
