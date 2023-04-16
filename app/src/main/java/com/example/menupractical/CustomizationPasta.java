package com.example.menupractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CustomizationPasta extends AppCompatActivity {
    public static int price, pasta;
    Button addCart;
    CheckBox cheese, corn, chilli,mush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customization);
        cheese = findViewById(R.id.cheese);
        corn = findViewById(R.id.corn);
        chilli = findViewById(R.id.chilli);
        mush = findViewById(R.id.mush);
        price = getIntent().getIntExtra("price", 0);
        pasta = getIntent().getIntExtra("pasta", 0);
        addCart = findViewById(R.id.addButton);
        addCart.setOnClickListener(this::onClick);
    }

    void onClick(View v) {
        String cus = "";
        if(cheese.isChecked()) {
            price += 25;
            cus += "MacCheese ";
        }
        if(corn.isChecked()) {
            price += 35;
            cus += "Babycorn ";
        }
        if(chilli.isChecked()) {
            price += 15;
            cus += "Oregano ";
        }
        if(mush.isChecked()) {
            price += 35;
            cus += "Mushroom ";
        }
        Intent intent = new Intent(CustomizationPasta.this, Cart.class);
        intent.putExtra("item", 2);
        intent.putExtra("price", price);
        intent.putExtra("pasta", pasta);
        intent.putExtra("Customization", "(" + cus + ")");
        startActivity(intent);
    }

}