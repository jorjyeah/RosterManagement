package id.ac.umn.rostermanagement;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
}
