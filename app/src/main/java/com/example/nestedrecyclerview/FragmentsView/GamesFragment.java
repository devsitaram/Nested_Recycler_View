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

import com.example.nestedrecyclerview.AdapterController.GamesAdapter;
import com.example.nestedrecyclerview.PojoModel.GamesModelClass;
import com.example.nestedrecyclerview.PojoModel.ParentModelClass;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Objects;

public class GamesFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<GamesModelClass> gamesModelClassList;
    View viewGames;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewGames = inflater.inflate(R.layout.fragment_games, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);
        recyclerView = viewGames.findViewById(R.id.rv_games);

        // used the divider
        @SuppressLint("UseRequireInsteadOfGet")
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(divider);

        gamesModelClassList = new ArrayList<>();
        gamesModelClassList.add(new GamesModelClass("Facebook", "9808765123"));
        gamesModelClassList.add(new GamesModelClass("Google", "9710509875"));
        gamesModelClassList.add(new GamesModelClass("Learn Coding", "980126833"));
        gamesModelClassList.add(new GamesModelClass("Twitter", "9811250109"));
        gamesModelClassList.add(new GamesModelClass("Alarms", "9812345670"));
        gamesModelClassList.add(new GamesModelClass("Tik Tok", "9701375013"));
        gamesModelClassList.add(new GamesModelClass("Messenger", "9835012344"));
        gamesModelClassList.add(new GamesModelClass("Instragram", "98025225"));
        gamesModelClassList.add(new GamesModelClass("Audio", "9876893210"));
        gamesModelClassList.add(new GamesModelClass("Youtube", "9713093422"));
        gamesModelClassList.add(new GamesModelClass("Java", "9705764392"));
        gamesModelClassList.add(new GamesModelClass("Meets", "9812345601"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        GamesAdapter adapter = new GamesAdapter(getActivity(), gamesModelClassList);
        recyclerView.setAdapter(adapter);

    }
}