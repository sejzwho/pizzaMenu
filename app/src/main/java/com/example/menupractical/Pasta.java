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

public class Pasta extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageView sel;
    public static int price;
    ImageView imageView1,imageView2,imageView3;
    int pasta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta);
        price = 0;
        imageView1 = findViewById(R.id.pastaImage_1);
        imageView2 = findViewById(R.id.pastaImage_2);
        imageView3 = findViewById(R.id.pastaImage_3);
        registerForContextMenu(imageView1);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==imageView1.getId()) {
            pasta = 1;
        }
        else if(v.getId()==imageView2.getId()) {
            pasta = 2;
        }
        else if(v.getId()==imageView3.getId()) {
            pasta = 3;
        }
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        if(v.getId()==imageView1.getId()) {
            pasta = 1;
        }
        else if(v.getId()==imageView2.getId()) {
            pasta = 2;
        }
        else if(v.getId()==imageView3.getId()) {
            pasta = 3;
        }
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.cart) {
            Intent intent = new Intent(Pasta.this, Cart.class);
            intent.putExtra("item", 2);
            intent.putExtra("price", 0);
            intent.putExtra("pasta", pasta);
            intent.putExtra("Customization", "");
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CustomizationPasta.class);
        intent.putExtra("price", price);
        intent.putExtra("pasta", pasta);
        startActivity(intent);
        return true;
    }
}