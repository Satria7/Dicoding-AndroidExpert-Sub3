package com.putrasamawa.dicodingmade1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.putrasamawa.dicodingmade1.model.Item;

//* Satria Junanda *//

public class DetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView textView1, textView2;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        Item exampleModel = intent.getParcelableExtra("Model");


        String title = exampleModel.getImageResource();
        String des = exampleModel.getText1();
        String imgs = exampleModel.getText2();

        img = findViewById(R.id.image_activity2);
        textView1 = findViewById(R.id.text1_activity2);
        textView2 = findViewById(R.id.text2_activity2);
        progressBar = findViewById(R.id.progress);

        if (title == null || des == null || imgs == null) {
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Data gagal dimuat", Toast.LENGTH_SHORT).show();
        } else {
            textView1.setText(title);
            textView2.setText(des);
            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w342/" + imgs)
                    .into(img);
            Toast.makeText(this, "Data berhasil dimuat", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void exit(View view) {
        finish();
    }

    public void fav(View view) {
        Toast.makeText(DetailActivity.this,"Berhasil ditambahkan ke favorit",Toast.LENGTH_SHORT).show();
    }
}

//* Satria Junanda *//