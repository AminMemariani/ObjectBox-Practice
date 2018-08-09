package com.example.admin.myapplicationtest.listing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.myapplicationtest.R;
import com.example.admin.myapplicationtest.core.MyApplication;
import com.example.admin.myapplicationtest.models.Zoo;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ZooList extends AppCompatActivity {

    TextView listText;
    BoxStore boxStore = MyApplication.getApp().getBoxStore();
    Box<Zoo> zooBox = boxStore.boxFor(Zoo.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_list);
        listText = findViewById(R.id.zooListText);

        List<Zoo> zoos = zooBox.getAll();

        for(Zoo zoo : zoos){
            listText.setText(zoo.getName().toString() + "\n");
        }

    }
}
