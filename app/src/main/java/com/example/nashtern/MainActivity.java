package com.example.nashtern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username=findViewById(R.id.username);
        TextView password=findViewById(R.id.password);

        Button loginbtn=(Button) (findViewById(R.id.login));

        //admin admin
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();}
                else
                    Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
            }
        });

    }
}