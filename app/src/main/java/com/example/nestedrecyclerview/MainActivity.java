package com.example.nestedrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    EditText editText_search;
    Button btnNotification;
    ImageView ivUserProfile;
    TextView tvNavbarForYou, tvNavbarTopChart, tvNavbarChildren, tvNavbarPremium, tvNavbarCategory;

    @SuppressLint({"NotifyDataSetChanged", "MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the object
        BottomNavigationView bottomNavigationView = findViewById(R.id.btnNavicationIcon);
        ContactsFragment contactsFragment = new ContactsFragment();
        GamesFragment gamesFragment = new GamesFragment();
        AppsFragment appsFragment = new AppsFragment();
        // variable initialize
        editText_search = findViewById(R.id.editText_search);
        ivUserProfile = findViewById(R.id.iv_userProfile);
        btnNotification = findViewById(R.id.btn_notification);
        tvNavbarForYou = findViewById(R.id.tv_navForYou);
        tvNavbarTopChart = findViewById(R.id.tv_navTopCharts);
        tvNavbarChildren = findViewById(R.id.tv_navChildren);
        tvNavbarPremium = findViewById(R.id.tv_navPremium);
        tvNavbarCategory = findViewById(R.id.tv_navCategoties);

        // already show the apps fragment class
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_mainContener, appsFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_navApps:
                        // go to the apps fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_mainContener, appsFragment).commit();
                        return true;
                    case R.id.btn_navGames:
                        // go to the game fragment class
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_mainContener, gamesFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // edit text fields
        editText_search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
                return false;
            }
        });
        // notification button
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Notification");
                builder.setMessage("No new notifications");
                // press the yes the logout the app
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        toastMassage("Thank you");
                    }
                });
                // press the No then cancel to logout the app
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        // contact class
        ivUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_mainContener, contactsFragment).commit();
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}