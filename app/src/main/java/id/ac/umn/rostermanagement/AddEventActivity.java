package id.ac.umn.rostermanagement;

import android.app.DialogFragment;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

public class AddEventActivity extends AppCompatActivity {

    // Array of strings...
    String jobList[] = {"Photo 1", "Photo 2", "Photo 3", "Photo CC",
            "Photo PK", "Photo TX", "Video 1", "Video 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_list_job_view, jobList);

        ListView listView = (ListView) findViewById(R.id.job);
        listView.setAdapter(adapter);

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
        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
    // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
    // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, getString(R.string.time) + timeMessage,
                Toast.LENGTH_SHORT).show();
    }
}
