package com.example.itcapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.itcapi.model.EventsItem;
import com.example.itcapi.service.SportService;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JadwalListener{

    RecyclerView rvRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SportService().getJadwal(this);
    }

    @Override
    public void onSuccess(List<EventsItem> items) {
        rvRecyclerView = findViewById(R.id.recycler_view);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvRecyclerView.setAdapter(new MainAdapter(items));

        for(int i = 0; i < items.size(); i++){
            Log.d("ISI DATA : ", items.get(i).getStrEvent());
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("ISI ERROR", msg);
    }
}
