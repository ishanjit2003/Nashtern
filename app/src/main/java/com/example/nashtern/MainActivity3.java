package com.example.nashtern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        superListView = findViewById(R.id.list);


        TextView t=findViewById(R.id.textView2);

        String username=getIntent().getStringExtra("name");
        t.setText("Hello "+username);

        getSuperHeroes();


    }


    private void getSuperHeroes() {
        Call <List< Model >> call = RetrofitClient.getInstance()
                .getMyApi()
                .getsuperHeroes();
        call.enqueue(new Callback < List < Model >> () {
            @Override
            public void onResponse(Call < List < Model >> call, Response< List < Model >> response) {
                List < Model > myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i)
                            .getName();
                }

                superListView.setAdapter(new ArrayAdapter< String >(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG)
                        .show();
            }

        });
    }





}