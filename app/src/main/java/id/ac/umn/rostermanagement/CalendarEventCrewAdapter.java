package id.ac.umn.rostermanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalendarEventCrewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String[] events;
    String[] positions;
    String[] dates;
    String[] teammanagers;
    String[] shifts;

    public CalendarEventCrewAdapter(Context context, String[] event, String[] pos, String[] tgl, String[] teammanager, String[] shif){
        this.context=context;
        this.events=event;
        this.positions=pos;
        this.dates=tgl;
        this.teammanagers=teammanager;
        this.shifts=shif;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.costume_row_event_crew_list,parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).eventView.setText(events[position]);
        ((Item)holder).positionView.setText(positions[position]);
        ((Item)holder).dateView.setText(dates[position]);
        ((Item)holder).tmView.setText(teammanagers[position]);
        ((Item)holder).shiftView.setText(shifts[position]);
    }

    @Override
    public int getItemCount() {
        return events.length;
    }

    public  class Item extends RecyclerView.ViewHolder{
        TextView eventView;
        TextView positionView;
        TextView dateView;
        TextView tmView;
        TextView shiftView;
        public Item(View itemView){
            super(itemView);
            eventView = (TextView) itemView.findViewById(R.id.eventview);
            positionView = (TextView) itemView.findViewById(R.id.positionview);
            dateView = (TextView) itemView.findViewById(R.id.dateview);
            tmView = (TextView) itemView.findViewById(R.id.tmview);
            shiftView = (TextView) itemView.findViewById(R.id.shiftview);

        }
    }
}
