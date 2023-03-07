package com.example.nestedrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.nestedrecyclerview.FragmentsView.AppsFragment;
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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btnNavicationIcon);
        GamesFragment gamesFragment = new GamesFragment();
        AppsFragment appsFragment = new AppsFragment();

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
}