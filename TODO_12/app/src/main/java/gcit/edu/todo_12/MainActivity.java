package gcit.edu.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TextView donut,icecream,froyo;
    private FloatingActionButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut = findViewById(R.id.donut_des);
        icecream = findViewById(R.id.icecream_des);
        froyo = findViewById(R.id.froyo_des);
        call = findViewById(R.id.call);
    }

    public void Donut(View view) {
        Toast toast = Toast.makeText(this,R.string.order1,Toast.LENGTH_LONG);
        toast.show();
    }

    public void Icecream(View view) {
        Toast toast = Toast.makeText(this,R.string.order2,Toast.LENGTH_LONG);
        toast.show();
    }

    public void Froyo(View view) {
        Toast toast = Toast.makeText(this,R.string.order3,Toast.LENGTH_LONG);
        toast.show();
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}