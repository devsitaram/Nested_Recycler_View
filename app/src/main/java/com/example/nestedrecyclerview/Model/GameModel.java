package com.example.nestedrecyclerview.Model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GameModel {
    public int image;
    public String name;

    public GameModel(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
