  package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

  public class StudentsActivity extends AppCompatActivity {

    ListView ls;
    String nom,classe;
    HashMap<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        ls=findViewById(R.id.ls);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            nom= extras.getString("nom");
            classe= extras.getString("classe");
            map= new HashMap<String,String>();
            map.put("nom",nom);
            map.put("classe",classe);
            Params.values.add(map);
        }

        SimpleAdapter adapter= new SimpleAdapter(StudentsActivity.this, Params.values,R.layout.item,
                new String[]{"nom", "classe"},
                new int[]{R.id.nomItem, R.id.classeItem}
                );

        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),DetailActivity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }
}