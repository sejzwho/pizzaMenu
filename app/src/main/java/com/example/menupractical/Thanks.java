package com.example.menupractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Thanks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks);
        TextView txt = findViewById(R.id.total);
        int total = getIntent().getIntExtra("total", 0);
        txt.setText("Your order value is ₹" + total);
    }
}