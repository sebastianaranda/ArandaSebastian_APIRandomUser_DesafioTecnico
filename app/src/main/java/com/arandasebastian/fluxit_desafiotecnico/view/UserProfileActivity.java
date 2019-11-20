package com.arandasebastian.fluxit_desafiotecnico.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String KEY_USER = "key_user";
    private Toolbar toolbar;
    private CircleImageView imgUser;
    private TextView txtAge;
    private TextView txtFistName;
    private TextView txtLastName;
    private TextView txtPhone;
    private TextView txtCell;
    private TextView txtEmail;
    private TextView txtCountry;
    private GoogleMap mMap;
    protected Double latitude;
    protected Double longitude;
    protected String userFirstName;
    protected String userLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        toolbar = findViewById(R.id.custom_toolbar_user_profile);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        userFirstName = selectedUser.getName().getFirstName();
        txtLastName.setText(selectedUser.getName().getLastName());
        userLastName = selectedUser.getName().getLastName();
        txtPhone.setText(selectedUser.getPhone());
        txtCell.setText(selectedUser.getCell());
        txtEmail.setText(selectedUser.getEmail());
        txtCountry.setText(selectedUser.getLocation().getCountry());
        latitude = selectedUser.getLocation().getCoordinates().getLatitude();
        longitude = selectedUser.getLocation().getCoordinates().getLongitude();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_container_en_activity);
        toolbar.setTitle(selectedUser.getName().getFirstName());
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng userLocation = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Ubicación de: "+userFirstName +" "+userLastName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
    }

}
