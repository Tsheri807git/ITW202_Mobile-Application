package com.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText FName, LName, Marks, Id;
    Button add, view, delete, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        FName = findViewById(R.id.fname);
        LName = findViewById(R.id.lname);
        Marks = findViewById(R.id.marks);
        Id = findViewById(R.id.idNum);
        add = findViewById(R.id.add);

    }

    public void addData(View view) {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(Id.getText().toString(),
                        LName.getText().toString(),
                        Marks.getText().toString(), FName.getText().toString());
                if (isInserted == true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();


            }
        });


    }

    public void ViewData(View view) {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student ID : "+ res.getString(0)+"\n");
            buffer.append("First Name : "+ res.getString(1)+"\n");
            buffer.append("Last Name : "+ res.getString(2)+"\n");
            buffer.append("Marks : "+ res.getString(3)+"\n\n");
        }

        showMessage("List of students",buffer.toString());
    }

    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData(View view) {
        boolean isUpdate = myDb.updateData(Id.getText().toString(),
                FName.getText().toString(),
                LName.getText().toString(),Marks.getText().toString());
        if (isUpdate == true)
            Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
    }

    public void DeleteData(View view) {
        Integer deletedRows = myDb.deleteData(Id.getText().toString());
        if (deletedRows > 0)
            Toast.makeText(MainActivity.this, "Data Deleted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data  not Deleted",Toast.LENGTH_SHORT).show();
    }
}