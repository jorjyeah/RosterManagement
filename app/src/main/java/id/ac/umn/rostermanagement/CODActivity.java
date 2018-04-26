package id.ac.umn.rostermanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CODActivity extends AppCompatActivity {
    String positionlist[] = {"Photo 1", "Photo 2", "Photo 3", "Photo CC",
            "Photo PK", "Photo TX", "Video 1", "Video 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recyclerView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod);

        recyclerView = (RecyclerView) findViewById(R.id.jobrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.addItemDecoration(new VerticalSpace(20));
        recyclerView.setAdapter(new CODAdapter(this,positionlist));
    }
}
