package com.example.admin.myapplicationtest;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.view.View;import android.widget.Button;import android.widget.TextView;import com.example.admin.myapplicationtest.core.MyApplication;import com.example.admin.myapplicationtest.models.Animal;import com.example.admin.myapplicationtest.models.Zoo;import io.objectbox.Box;import io.objectbox.BoxStore;public class MainActivity extends AppCompatActivity {    private BoxStore boxStore = MyApplication.getApp().getBoxStore();    private Box<Animal> animalBox = boxStore.boxFor(Animal.class);    private TextView animalTV , zooTV;    private Button submit;    @Override    protected void onCreate(Bundle savedInstanceState) {        setContentView(R.layout.activity_main);        getViewFromXML();        submit.setOnClickListener( new View.OnClickListener(){            @Override            public void onClick(View v) {                Animal animal = new Animal();                Zoo myZoo = new Zoo();                animal.setName(animalTV.getText().toString());                myZoo.setName(zooTV.getText().toString());                animal.getZoo().setTarget(myZoo);                animalBox.put(animal);            }        });        super.onCreate(savedInstanceState);    }    public void getViewFromXML(){        animalTV = findViewById(R.id.animalrNameText);        zooTV = findViewById(R.id.zooNameText);        submit = findViewById(R.id.submit);    }}