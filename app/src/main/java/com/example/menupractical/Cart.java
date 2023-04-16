package com.example.menupractical;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    public static int pizza = 0, pasta = 0, amount = 0, add, price, pizzaChoice, pastaChoice;
    public static String str = "", cus = "";
    TextView textPizza;
    TextView textPasta;
    TextView total;
    Button place;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        textPizza = findViewById(R.id.orderText);
        textPasta = findViewById(R.id.orderText);
        total = findViewById(R.id.total);
        place = findViewById(R.id.Place);
        add = getIntent().getIntExtra("item", 0);
        price = getIntent().getIntExtra("price", 0);
        pizzaChoice = getIntent().getIntExtra("pizza", 0);
        pastaChoice = getIntent().getIntExtra("pasta", 0);
        cus = getIntent().getStringExtra("Customization");
        if(cus.equals("()")) {
            cus = "";
        }
        if(add == 1) {
            if(pizzaChoice == 1) {
                str += "Margherita      ₹" + (99+price) + cus + "\n";
                amount += 99;
            } else if(pizzaChoice == 2) {
                str += "Farm House      ₹" + (199+price) + cus + "\n";
                amount += 199;
            }
            else if(pizzaChoice == 3) {
                str += "Deluxe Veggie      ₹" + (299+price) + cus + "\n";
                amount += 299;
            }
        }
        else if(add == 2) {
            if(pastaChoice == 1) {
                str += "Red Pasta      ₹" + (189+price) + cus + "\n";
                amount += 189;
            } else if(pastaChoice == 2) {
                str += "White Pasta      ₹" + (199+price) + cus + "\n";
                amount += 199;
            }
            else if(pastaChoice == 3) {
                str += "Italian Pasta      ₹" + (299+price) + cus + "\n";
                amount += 299;
            }
        }
        amount += price;
        textPizza.setText(str);
        total.setText("Total: ₹" + amount);

        place.setOnClickListener(this::onClick);
    }

    void onClick(View v) {
        Intent intent = new Intent(this, Thanks.class);
        intent.putExtra("total", amount);
        startActivity(intent);
    }

}