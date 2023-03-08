package com.example.nestedrecyclerview;

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

import com.example.nestedrecyclerview.Presenter.ContactsAdapter;
import com.example.nestedrecyclerview.Model.ContactsModel;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Objects;

public class ContactsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ContactsModel> contactsModelClassList;
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

        recyclerView = viewGames.findViewById(R.id.rv_contacts);

        // used the divider
        @SuppressLint("UseRequireInsteadOfGet")
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        contactsModelClassList = new ArrayList<>();
        contactsModelClassList.add(new ContactsModel("Facebook", "9808765123"));
        contactsModelClassList.add(new ContactsModel("Google", "9710509875"));
        contactsModelClassList.add(new ContactsModel("Learn Coding", "980126833"));
        contactsModelClassList.add(new ContactsModel("Twitter", "9811250109"));
        contactsModelClassList.add(new ContactsModel("Alarms", "9812345670"));
        contactsModelClassList.add(new ContactsModel("Tik Tok", "9701375013"));
        contactsModelClassList.add(new ContactsModel("Messenger", "9835012344"));
        contactsModelClassList.add(new ContactsModel("Instragram", "98025225"));
        contactsModelClassList.add(new ContactsModel("Audio", "9876893210"));
        contactsModelClassList.add(new ContactsModel("Youtube", "9713093422"));
        contactsModelClassList.add(new ContactsModel("Java", "9705764392"));
        contactsModelClassList.add(new ContactsModel("Meets", "9812345601"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ContactsAdapter adapter = new ContactsAdapter(getActivity(), contactsModelClassList);
        recyclerView.setAdapter(adapter);

    }
}