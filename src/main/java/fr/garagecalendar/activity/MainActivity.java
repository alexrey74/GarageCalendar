package fr.garagecalendar.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

import fr.garagecalendar.R;
import fr.garagecalendar.manager.ProfileManager;
import fr.garagecalendar.model.Slot;
import fr.garagecalendar.model.User;
import fr.garagecalendar.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;
    TextView date_table;
    Button btn_add_slot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final User user = ProfileManager.getInstance().getUser();

        Log.i("CURRENT USER --- ", user.getPassword());

        calendar = (CalendarView)findViewById(R.id.calendar);
        date_view = (TextView)findViewById(R.id.date_view);
        date_table = (TextView)findViewById(R.id.date_table);
        btn_add_slot = (Button)findViewById(R.id.btnAddSlot);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String strDate = dayOfMonth + "-" + (month + 1) + "-" + year;
                date_view.setText(strDate);
                try{
                    LocalDate date = LocalDate.now();
                    ArrayList<Slot> slots = ProfileManager.getInstance().getUser().getSlots();

                    for(Slot slot: slots){
                        Log.i("SLOT DATE -- ", slot.getDate().toString());
                        if(slot.getDate().equals(date)){
                            date_table.setText(user.getName() + " :: Début : " + slot.getStart() + "H -- Durée :  " + slot.getDuration());
                        }
                    }
                } catch (Exception e){
                    Log.w("Exception -- ", e.getMessage());
                }
            }
        });

        btn_add_slot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.launchActivity(MainActivity.this, AddSlotActivity.class, ActivityUtils.TYPE_FADE);
            }
        });
    }
}
