package com.example.menupractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Pizza extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageView sel;
    public static int price;
    ImageView imageView1,imageView2,imageView3;
    int pizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        price = 0;
        setContentView(R.layout.pizza);
        imageView1 = findViewById(R.id.pizzaImage_1);
        imageView2 = findViewById(R.id.pizzaImage_2);
        imageView3 = findViewById(R.id.pizzaImage_3);
        registerForContextMenu(imageView1);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        if(v.getId()==imageView1.getId()) {
            pizza = 1;
        }
        else if(v.getId()==imageView2.getId()) {
            pizza = 2;
        }
        else if(v.getId()==imageView3.getId()) {
            pizza = 3;
        }
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.cart) {
            Intent intent = new Intent(Pizza.this, Cart.class);
            intent.putExtra("item", 1);
            intent.putExtra("price", 0);
            intent.putExtra("pizza", pizza);
            intent.putExtra("Customization", "");
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId()==imageView1.getId()) {
            pizza = 1;
        }
        else if(v.getId()==imageView2.getId()) {
            pizza = 2;
        }
        else if(v.getId()==imageView3.getId()) {
            pizza = 3;
        }

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent = new Intent(Pizza.this, CustomizationPizza.class);
        intent.putExtra("price", price);
        intent.putExtra("pizza", pizza);
        startActivity(intent);
        return true;
    }
}