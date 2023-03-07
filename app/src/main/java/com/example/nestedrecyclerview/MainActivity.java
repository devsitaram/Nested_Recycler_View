package com.example.nestedrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nestedrecyclerview.FragmentsView.AppsFragment;
import com.example.nestedrecyclerview.FragmentsView.ContactsFragment;
import com.example.nestedrecyclerview.FragmentsView.GamesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    ParentAdapter parentAdapter;
//    ArrayList<ParentModelClass> parentModelClassList;
//    ArrayList<ChildModelClass> childModelClassList;
//    ArrayList<ChildModelClass> favoriteList;
//    ArrayList<ChildModelClass> recentlyWatchList;
//    ArrayList<ChildModelClass> latestList;

    Button btnNotification;
    ImageView ivUserProfile;
    @SuppressLint({"NotifyDataSetChanged", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // variable initialize
        BottomNavigationView bottomNavigationView = findViewById(R.id.btnNavicationIcon);
        ContactsFragment contactsFragment = new ContactsFragment();
        GamesFragment gamesFragment = new GamesFragment();
        AppsFragment appsFragment = new AppsFragment();
        ivUserProfile= findViewById(R.id.iv_userProfile);
        btnNotification =findViewById(R.id.btn_notification);

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

                        Toast.makeText()
//                        // go to the one fragment to another fragment
//                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.LoginFrameContener, passwordForgotFragment).commit();
                    }
                });
                // press the No then cancel to logout the app
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });builder.show();
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
    public void toastMassage(String message){
        Toast.makeText(new MainActivity(), message, Toast.LENGTH_SHORT).show();
    }
}

//        Objects.requireNonNull(getSupportActionBar()).hide();

//        recyclerView = findViewById(R.id.rv_parent);
//        parentModelClassList= new ArrayList<>();
//
//        // used the divider
//        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
//        recyclerView.addItemDecoration(divider);
//
//        // latest list
//        latestList= new ArrayList<>();
//        latestList.add(new ChildModelClass(R.mipmap.img_messenger,"Messenger","⭐⭐"));
//        latestList.add(new ChildModelClass(R.mipmap.img_facebook,"Facebook","⭐⭐⭐"));
//        latestList.add(new ChildModelClass(R.mipmap.img_instragram,"Instragram","⭐⭐"));
//        latestList.add(new ChildModelClass(R.mipmap.img_whatsapp,"Whatsapp","⭐⭐"));
//        latestList.add(new ChildModelClass(R.mipmap.img_twitter,"Twitter","⭐⭐⭐"));
//        latestList.add(new ChildModelClass(R.mipmap.img_imo, "Imo", "⭐⭐"));
//        parentModelClassList.add(new ParentModelClass("Tending App", latestList));
//
//        recentlyWatchList= new ArrayList<>();
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_alarm,"Messenger","⭐⭐⭐"));
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_learn_coding,"Code Learn","⭐⭐"));
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_user_profile,"Contact","⭐⭐"));
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_viber,"Viber","⭐⭐⭐"));
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_meets,"Meets","⭐⭐"));
//        recentlyWatchList.add(new ChildModelClass(R.mipmap.img_java,"Java","⭐⭐⭐"));
//        parentModelClassList.add(new ParentModelClass("Recently Watch", recentlyWatchList));
//
//        // favorite list
//        favoriteList= new ArrayList<>();
//        favoriteList.add(new ChildModelClass(R.mipmap.img_music,"Music","⭐⭐"));
//        favoriteList.add(new ChildModelClass(R.mipmap.img_youtube,"Youtube","⭐⭐⭐"));
//        favoriteList.add(new ChildModelClass(R.mipmap.img_gamil,"Gmail","⭐⭐"));
//        favoriteList.add(new ChildModelClass(R.mipmap.img_google,"Google","⭐⭐⭐"));
//        favoriteList.add(new ChildModelClass(R.mipmap.img_coc,"COC","⭐⭐⭐"));
//        parentModelClassList.add(new ParentModelClass("Favorites", favoriteList));
//
//        // child model clas
//        childModelClassList= new ArrayList<>();
//        childModelClassList.add(new ChildModelClass(R.mipmap.img_java,"Java","⭐⭐⭐"));
//        childModelClassList.add(new ChildModelClass(R.mipmap.img_html,"HTML","⭐⭐"));
//        childModelClassList.add(new ChildModelClass(R.mipmap.img_python,"Python","⭐"));
//        childModelClassList.add(new ChildModelClass(R.mipmap.img_learn_coding,"Learn Code","⭐⭐⭐"));
//        childModelClassList.add(new ChildModelClass(R.mipmap.img_databases,"Databases","⭐⭐"));
//        parentModelClassList.add(new ParentModelClass("Grade", childModelClassList));
//
//        // adding
//        parentAdapter= new ParentAdapter(this, parentModelClassList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(parentAdapter);
//        parentAdapter.notifyDataSetChanged();
//}