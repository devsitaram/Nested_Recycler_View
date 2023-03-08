package com.example.nestedrecyclerview.Presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.Model.ContactsModel;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactsModel> contactsModelClassesArrayList;

    public ContactsAdapter(Context context, ArrayList<ContactsModel> contactsModelClassesArrayList) {
        this.context = context;
        this.contactsModelClassesArrayList = contactsModelClassesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.contacts_items, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactsModel gamesModelClass = contactsModelClassesArrayList.get(position);
        holder.tvAlphabet.setText(gamesModelClass.getProfileLetter().toString());
        holder.tvAlphabet.setBackgroundColor(ContactsModel.getColor());

        holder.tvName.setText(contactsModelClassesArrayList.get(position).name);
        holder.tvNumber.setText(contactsModelClassesArrayList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return contactsModelClassesArrayList.size();
    }

    // sub classes
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlphabet, tvName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlphabet = itemView.findViewById(R.id.iv_contact_item);
            tvName = itemView.findViewById(R.id.tvUserName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}
