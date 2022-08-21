package com.example.roomdatbase_r_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class fetchData extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        getRoomData();
    }
    public void getRoomData(){

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "RoomDataBase").allowMainThreadQueries().build();
        UserDao userDao= db.userDao();


        List<User> users= userDao.getAllUsers();
        myAdapter adapter=new myAdapter(users);
        recyclerView.setAdapter(adapter);



    }
}