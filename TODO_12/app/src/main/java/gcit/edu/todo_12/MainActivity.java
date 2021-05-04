package gcit.edu.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final String Extra_MESSAGE = "com.gcit.todo_13.extra.MESSAGE";

    private TextView donut,icecream,froyo;
    private FloatingActionButton order;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut = findViewById(R.id.donut_des);
        icecream = findViewById(R.id.icecream_des);
        froyo = findViewById(R.id.froyo_des);
        order = findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void Shopping (View view){
                Intent intent = new Intent(MainActivity.this, OrderingActivity.class);
                intent.putExtra(Extra_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();
        return true;
    }

    public void displayToast(String message){
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