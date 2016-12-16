package com.sunrin.database_realm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends Activity {

    private ListView listAnimal;
    private CustomAdapter customAdapter;
    private Button btnAdd;
    private EditText editType, editName, editAge;

    private Realm realm;
    private List<Pet> petList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRealm();

        initEditText();
        initButton();
        initListView();
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void initListView() {
        listAnimal = (ListView) findViewById(R.id.list_animal);
        customAdapter = new CustomAdapter(getPets());
        listAnimal.setAdapter(customAdapter);
    }

    private void initButton() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = editType.getText().toString();
                String name = editName.getText().toString();
                int age = Integer.valueOf(editAge.getText().toString());
                realm.beginTransaction();
                Pet pet = realm.createObject(Pet.class);
                pet.setType(type);
                pet.setName(name);
                pet.setAge(age);
                realm.commitTransaction();
                getPets();
                customAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initEditText() {
        editAge = (EditText) findViewById(R.id.edit_age);
        editName = (EditText) findViewById(R.id.edit_name);
        editType = (EditText) findViewById(R.id.edit_type);
    }


    private List<Pet> getPets() {
        RealmResults<Pet> pets = realm.where(Pet.class).findAll();
        petList.clear();
        for (Pet pet : pets) {
            petList.add(pet);
        }
        return petList;
    }


}
