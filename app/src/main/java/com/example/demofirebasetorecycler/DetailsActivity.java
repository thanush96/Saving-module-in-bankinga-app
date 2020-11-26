package com.example.demofirebasetorecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView img;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img=(ImageView)findViewById(R.id.dimg);
        tv1=(TextView)findViewById(R.id.dname);
        tv2=(TextView)findViewById(R.id.drate);

       img.setImageResource(getIntent().getIntExtra("image",0));
        tv1.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("rate"));

    }
}