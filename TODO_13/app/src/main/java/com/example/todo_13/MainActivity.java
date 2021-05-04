package com.example.todo_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.android.todo_13.extra.MESSAGE";

    private TextView donut,icecream,froyo;
    private FloatingActionButton calls;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut=findViewById(R.id.donut_des);
        icecream=findViewById(R.id.icecream_des);
        froyo=findViewById(R.id.froyo_des);


        FloatingActionButton fab = findViewById(R.id.chart);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Order.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
            return true;
        }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }
    public void CupcakeOrder(View view) {
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void EclairOrder(View view) {
        mOrderMessage = getString(R.string.icecream_order);
        displayToast(mOrderMessage);
    }

    public void FroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);

    }
}