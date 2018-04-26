package id.ac.umn.rostermanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CalendarEventCrewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String [] Event={"Sunday Service", "Sunday Service", "Woman Fellowship"};
    String [] Position={"Photographer 1","Photographer 1", "Photographer 2"};
    String [] Teammanager={"George", "George", "Albert"};
    String [] Shift={"Shift 1", "Shift 2", "18.00",};
    String [] Date={"4/22/2018", "4/29/2018", "5/3/2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_event_crew);

//        CardView cardView = (CardView) findViewById(R.id.cardvieweventcrew);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(CalendarEventCrewActivity.this,PositionDetailCrewActivity.class);
//            }
//        });
        recyclerView = (RecyclerView) findViewById(R.id.calendareventcrewrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new VerticalSpace(20));
        recyclerView.setAdapter(new CalendarEventCrewAdapter(this,Event,Position,Date,Teammanager,Shift));
    }
}
