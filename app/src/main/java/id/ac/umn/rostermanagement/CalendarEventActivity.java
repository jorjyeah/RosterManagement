package id.ac.umn.rostermanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class CalendarEventActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String [] Items={"item 0","item 1","item 0","item 1","item 0","item 1","item 0","item 1",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_event);

        FloatingActionButton addfab = (FloatingActionButton) findViewById(R.id.addeventfab);
        addfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarEventActivity.this,AddEventActivity.class));
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.calendareventrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CalendarEventAdapter(this,Items));
    }
}
