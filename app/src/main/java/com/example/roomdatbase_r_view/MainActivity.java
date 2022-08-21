package com.example.roomdatbase_r_view;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText firstName,secondName,userID;
    private Button save,fetch;
    private TextView msgTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID=findViewById(R.id.userId);
        firstName=findViewById(R.id.firstName);
        secondName=findViewById(R.id.secondName);

        msgTv=findViewById(R.id.showTV);


        fetch=findViewById(R.id.fetchDB);


        save=findViewById(R.id.saveToDB);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "RoomDataBase").allowMainThreadQueries().build();
                UserDao userDao= db.userDao();


                Boolean check=userDao.is_exist(Integer.parseInt(userID.getText().toString()));
                if(check==false)
                {
                    userDao.insert(new User(Integer.parseInt(userID.getText().toString()),firstName.getText().toString(),secondName.getText().toString()));
                    userID.setText("");
                    firstName.setText("");
                    secondName.setText("");
                    msgTv.setText("Inserted Successfully");


                }
                else {
                    userID.setText("");
                    firstName.setText("");
                    secondName.setText("");
                    msgTv.setText("Record is already exist");
                }


            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetchData.class));



            }
        });


    }
}