package com.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView donut,froyo,sandwich;
    private FloatingActionButton order;
    //private ImageView IDonut,Ifroyo,Isandwich;

    String ordered_msg;
    public static final String EXTRA_MESSAGE =
            "com.gcit.todo_12.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut=findViewById(R.id.txtDonut);
        froyo=findViewById(R.id.textfroyo);
        sandwich=findViewById(R.id.textsandwich);
        order=findViewById(R.id.fab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, ordered_msg);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.order:
                Intent intent = new Intent(MainActivity.this,
                        OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, ordered_msg);
                startActivity(intent);
                return true;

            case R.id.shop:
                Toast.makeText(MainActivity.this, getString(R.string.shop_item_toast), Toast.LENGTH_LONG).show();
                return true;

            case R.id.info:
                Toast.makeText(MainActivity.this, getString(R.string.info_item_toast), Toast.LENGTH_LONG).show();
                return true;

            case R.id.status:
                Toast.makeText(MainActivity.this, getString(R.string.status_item_toast), Toast.LENGTH_LONG).show();
                return true;

            case R.id.favourite:
                Toast.makeText(MainActivity.this, getString(R.string.fav_item_toast), Toast.LENGTH_LONG).show();
                return true;

            case R.id.contact:
                Toast.makeText(MainActivity.this, getString(R.string.contact_item_toast), Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Donut(View view) {
        ordered_msg = getString(R.string.order);
        displayToast(ordered_msg);
    }

    public void Sandwich(View view) {
        ordered_msg = getString(R.string.order2);
        displayToast(ordered_msg);
    }

    public void Froyo(View view) {
        ordered_msg = getString(R.string.order3);
        displayToast(ordered_msg);
    }
}