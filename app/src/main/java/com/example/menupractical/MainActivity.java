package com.example.menupractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.pizza:
                openPizza();
                return true;

            case R.id.pasta:
                openPasta();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void openPizza() {
        Intent intent = new Intent(this, Pizza.class);
        startActivity(intent);
    }

    public void openPasta() {
        Intent intent = new Intent(this, Pasta.class);
        startActivity(intent);
    }

}