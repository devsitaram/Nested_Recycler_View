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

import com.example.nestedrecyclerview.AdapterController.ContactsAdapter;
import com.example.nestedrecyclerview.PojoModel.ContactsModelClass;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Objects;

public class ContactsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ContactsModelClass> gamesModelClassList;
    View viewGames;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewGames = inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);
        recyclerView = viewGames.findViewById(R.id.rv_games);

        // used the divider
        @SuppressLint("UseRequireInsteadOfGet")
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(Objects.requireNonNull(getActivity()),DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(divider);

        gamesModelClassList = new ArrayList<>();
        gamesModelClassList.add(new ContactsModelClass("Facebook", "9808765123"));
        gamesModelClassList.add(new ContactsModelClass("Google", "9710509875"));
        gamesModelClassList.add(new ContactsModelClass("Learn Coding", "980126833"));
        gamesModelClassList.add(new ContactsModelClass("Twitter", "9811250109"));
        gamesModelClassList.add(new ContactsModelClass("Alarms", "9812345670"));
        gamesModelClassList.add(new ContactsModelClass("Tik Tok", "9701375013"));
        gamesModelClassList.add(new ContactsModelClass("Messenger", "9835012344"));
        gamesModelClassList.add(new ContactsModelClass("Instragram", "98025225"));
        gamesModelClassList.add(new ContactsModelClass("Audio", "9876893210"));
        gamesModelClassList.add(new ContactsModelClass("Youtube", "9713093422"));
        gamesModelClassList.add(new ContactsModelClass("Java", "9705764392"));
        gamesModelClassList.add(new ContactsModelClass("Meets", "9812345601"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ContactsAdapter adapter = new ContactsAdapter(getActivity(), gamesModelClassList);
        recyclerView.setAdapter(adapter);

    }
}