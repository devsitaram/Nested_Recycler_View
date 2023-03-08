package com.example.nestedrecyclerview.View.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nestedrecyclerview.R;


public class GamesFragment extends Fragment {

    RecyclerView recyclerView;
    View gameView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return gameView = inflater.inflate(R.layout.fragment_games, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstsnceStated){
        super.onViewCreated(view, savedInstsnceStated);

        recyclerView =gameView.findViewById(R.id.tv_gameName);

    }
}