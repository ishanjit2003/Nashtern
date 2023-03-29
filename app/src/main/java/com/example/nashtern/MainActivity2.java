package com.example.nashtern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    TextView captxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ImageView imgGallery = findViewById(R.id.imgGallery);
        Button btn = findViewById(R.id.button);
        Button done = findViewById(R.id.done);
        EditText name = findViewById(R.id.editText2);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prfname = name.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name", prfname);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Intent iGallery=new Intent(Intent.ACTION_PICK);
//              iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//              startActivityForResult(iGallery,1);

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1000);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if(requestCode==1 && resultCode==RESULT_OK &&null !=data){
//            Uri selectedImage=data.getData();
//            String[] filepath={MediaStore.Images.Media.DATA};
//            Cursor cursor=getContentResolver().query(selectedImage,filepath,null,null,null);
//            int columneIndex=cursor.getColumnIndex(filepath[0]);
//            String picturepath=cursor.getString(columneIndex);
//            cursor.close();

        if (requestCode == 1000 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ImageView imageView = findViewById(R.id.imgGallery);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}








