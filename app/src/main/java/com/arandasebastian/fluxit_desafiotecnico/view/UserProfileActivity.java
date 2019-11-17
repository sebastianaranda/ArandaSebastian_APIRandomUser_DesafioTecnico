package com.arandasebastian.fluxit_desafiotecnico.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.bumptech.glide.Glide;

public class UserProfileActivity extends AppCompatActivity {

    public static final String KEY_USER = "key_user";
    private ImageView imgUser;
    private TextView txtAge;
    private TextView txtFistName;
    private TextView txtLastName;
    private TextView txtPhone;
    private TextView txtCell;
    private TextView txtEmail;
    private TextView txtCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User selectedUser = (User) bundle.getSerializable(KEY_USER);

        imgUser = findViewById(R.id.user_profile_activity_user_image);
        txtAge = findViewById(R.id.user_profile_activity_text_age);
        txtFistName = findViewById(R.id.user_profile_activity_text_fistname);
        txtLastName = findViewById(R.id.user_profile_activity_text_lastname);
        txtPhone = findViewById(R.id.user_profile_activity_text_phone);
        txtCell = findViewById(R.id.user_profile_activity_text_cell);
        txtEmail = findViewById(R.id.user_profile_activity_text_email);
        txtCountry = findViewById(R.id.user_profile_activity_text_country);

        Glide.with(this)
                .load(selectedUser.getPictures().getPictureLarge())
                .placeholder(R.drawable.img_profile_placeholder)
                .into(imgUser);

        txtAge.setText(selectedUser.getDob().getAge().toString());
        txtFistName.setText(selectedUser.getName().getFirstName());
        txtLastName.setText(selectedUser.getName().getLastName());
        txtPhone.setText(selectedUser.getPhone());
        txtCell.setText(selectedUser.getCell());
        txtEmail.setText(selectedUser.getEmail());
        txtCountry.setText(selectedUser.getLocation().getCountry());
    }

}
