package com.example.nestedrecyclerview.FragmentsView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nestedrecyclerview.AdapterController.ParentAppsAdapter;
import com.example.nestedrecyclerview.PojoModel.ChildAppsModelClass;
import com.example.nestedrecyclerview.PojoModel.ParentAppsModelClass;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Objects;

public class AppsFragment extends Fragment {

    RecyclerView recyclerView;
    ParentAppsAdapter parentAdapter;
    ArrayList<ParentAppsModelClass> parentModelClassList;
    ArrayList<ChildAppsModelClass> childModelClassList;
    ArrayList<ChildAppsModelClass> favoriteList;
    ArrayList<ChildAppsModelClass> recentlyWatchList;
    ArrayList<ChildAppsModelClass> latestList;
    View viewApps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewApps = inflater.inflate(R.layout.fragment_apps, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = viewApps.findViewById(R.id.rv_parent);
        parentModelClassList = new ArrayList<>();

        // used the divider
        @SuppressLint("UseRequireInsteadOfGet")
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(divider);

        // latest list
        latestList = new ArrayList<>();
        latestList.add(new ChildAppsModelClass(R.mipmap.img_messenger, "Messenger", "⭐⭐"));
        latestList.add(new ChildAppsModelClass(R.mipmap.img_facebook, "Facebook", "⭐⭐⭐"));
        latestList.add(new ChildAppsModelClass(R.mipmap.img_instragram, "Instragram", "⭐⭐"));
        latestList.add(new ChildAppsModelClass(R.mipmap.img_whatsapp, "Whatsapp", "⭐⭐"));
        latestList.add(new ChildAppsModelClass(R.mipmap.img_twitter, "Twitter", "⭐⭐⭐"));
        latestList.add(new ChildAppsModelClass(R.mipmap.img_imo, "Imo", "⭐⭐"));
        parentModelClassList.add(new ParentAppsModelClass("Tending App", latestList));

        recentlyWatchList = new ArrayList<>();
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_alarm, "Messenger", "⭐⭐⭐"));
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_learn_coding, "Code Learn", "⭐⭐"));
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_user_profile, "Contact", "⭐⭐"));
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_viber, "Viber", "⭐⭐⭐"));
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_meets, "Meets", "⭐⭐"));
        recentlyWatchList.add(new ChildAppsModelClass(R.mipmap.img_java, "Java", "⭐⭐⭐"));
        parentModelClassList.add(new ParentAppsModelClass("Recently Watch", recentlyWatchList));

        // favorite list
        favoriteList = new ArrayList<>();
        favoriteList.add(new ChildAppsModelClass(R.mipmap.img_music, "Music", "⭐⭐"));
        favoriteList.add(new ChildAppsModelClass(R.mipmap.img_youtube, "Youtube", "⭐⭐⭐"));
        favoriteList.add(new ChildAppsModelClass(R.mipmap.img_gamil, "Gmail", "⭐⭐"));
        favoriteList.add(new ChildAppsModelClass(R.mipmap.img_google, "Google", "⭐⭐⭐"));
        favoriteList.add(new ChildAppsModelClass(R.mipmap.img_coc, "COC", "⭐⭐⭐"));
        parentModelClassList.add(new ParentAppsModelClass("Favorites", favoriteList));

        // child model clas
        childModelClassList = new ArrayList<>();
        childModelClassList.add(new ChildAppsModelClass(R.mipmap.img_java, "Java", "⭐⭐⭐"));
        childModelClassList.add(new ChildAppsModelClass(R.mipmap.img_html, "HTML", "⭐⭐"));
        childModelClassList.add(new ChildAppsModelClass(R.mipmap.img_python, "Python", "⭐"));
        childModelClassList.add(new ChildAppsModelClass(R.mipmap.img_learn_coding, "Learn Code", "⭐⭐⭐"));
        childModelClassList.add(new ChildAppsModelClass(R.mipmap.img_databases, "Databases", "⭐⭐"));
        parentModelClassList.add(new ParentAppsModelClass("Grade", childModelClassList));

        // adding
        parentAdapter = new ParentAppsAdapter(getActivity(), parentModelClassList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }
}