package id.ac.umn.rostermanagement;

import android.app.DialogFragment;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

public class AddEventActivity extends AppCompatActivity {

    // Array of strings...
    String positionlist[] = {"Photo 1", "Photo 2", "Photo 3", "Photo CC",
            "Photo PK", "Photo TX", "Video 1", "Video 2"};
    String[] selectShift = {"Shift 1", "Shift 2", "Shift 3", "Shift 4"};
    String[] tmphoto = {"-","Yemima", "Albert","Shereen", "George"};
    String[] tmcampers = {"-","Peter", "Daniel", "Tonny"};
    String[] tmpostpro = {"-", "Christopher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recyclerView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.activity_list_job_view, jobList);
//
//        ListView listView = (ListView) findViewById(R.id.job);
//        listView.setAdapter(adapter);

        //RECYCLER VIEW
        recyclerView = (RecyclerView) findViewById(R.id.jobrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.addItemDecoration(new VerticalSpace(20));
        recyclerView.setAdapter(new AddEventAdapter(this,positionlist));

        //SPINNER TM PHOTO
        Spinner sptmphoto = (Spinner) findViewById(R.id.tmphotospinner);
        final ArrayAdapter<String> adaptertmphoto = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, tmphoto);
        //set array to spinner
        sptmphoto.setAdapter(adaptertmphoto);
        //set listener when chosen
        sptmphoto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adaptertmphoto.getItem(position);
//                Toast.makeText(AddEventActivity.this,
//                        "Selected "+adaptertmphoto.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //SPINNER TM campers
        Spinner sptmcampers = (Spinner) findViewById(R.id.tmcampersspinner);
        final ArrayAdapter<String> adaptertmcampers = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, tmcampers);
        //set array to spinner
        sptmcampers.setAdapter(adaptertmcampers);
        //set listener when chosen
        sptmcampers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adaptertmcampers.getItem(position);
//                Toast.makeText(AddEventActivity.this,
//                        "Selected "+adaptertmcampers.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //SPINNER TM postpro
        Spinner sptmpostpro = (Spinner) findViewById(R.id.tmpostprospinner);
        final ArrayAdapter<String> adaptertmpostpro = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, tmpostpro);
        //set array to spinner
        sptmpostpro.setAdapter(adaptertmpostpro);
        //set listener when chosen
        sptmpostpro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adaptertmpostpro.getItem(position);
//                Toast.makeText(AddEventActivity.this,
//                        "Selected "+adaptertmpostpro.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

//    public void onButtonShowPopupWindowClick(View view) {
//        RelativeLayout addEvent = (RelativeLayout) findViewById(R.id.add_event_layout);
//
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View popupView = inflater.inflate(R.layout.date_picker, null);
//
//        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
//        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
//        boolean focusable = true;
//        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//        popupWindow.showAtLocation(addEvent, Gravity.CENTER, 0 ,0);
//
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
//    }

    public void showDatePickerDialog(View v){
        DatePickerFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v){
        TimePickerFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getFragmentManager(), "datePicker");
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" +
                day_string + "/" + year_string);
        EditText dateText = (EditText) findViewById(R.id.dateText);
        dateText.setText(dateMessage);
//        Toast.makeText(this, getString(R.string.date) + dateMessage,
//                Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
    // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
    // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);
        EditText dateText = (EditText) findViewById(R.id.timeText);
        dateText.setText(timeMessage);
//        Toast.makeText(this, getString(R.string.time) + timeMessage,
//                Toast.LENGTH_SHORT).show();
    }

//    public void chooseShift(View view) {
//        ArrayAdapter<String> shift = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, selectShift);
//        AutoCompleteTextView timeTxt = (AutoCompleteTextView) findViewById(R.id.timeText);
//        timeTxt.setThreshold(3);
//        timeTxt.setAdapter(shift);
//    }
}
