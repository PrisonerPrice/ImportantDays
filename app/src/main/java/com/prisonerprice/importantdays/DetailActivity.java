package com.prisonerprice.importantdays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prisonerprice.importantdays.database.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    private EditText editDescription;
    private EditText editMonth;
    private EditText editDay;
    private EditText editYear;
    private EditText editRemainderDays;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editDescription = findViewById(R.id.editTextDescription);
        editMonth = findViewById(R.id.editTextMonth);
        editDay = findViewById(R.id.editTextDay);
        editYear = findViewById(R.id.editTextYear);
        editRemainderDays = findViewById(R.id.editTextRemainderDays);
        saveButton.setOnClickListener(view -> onSaveButtonClicked());
    }

    private void onSaveButtonClicked() {
        Date date = parseDate();
        int remainderDays = parseRemainderDays();
        if (date != null && remainderDays > 0) {
            Task task = new Task(
                    editDescription.getText().toString(),
                    remainderDays,
                    date
                    );
        }

    }

    private Date parseDate() {
        String date = editYear.getText().toString() + "-" + editMonth.getText().toString() + "-" + editDay.getText().toString();
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            Toast.makeText(this, "Not a valid date", Toast.LENGTH_SHORT);
            return null;
        }
    }

    private int parseRemainderDays() {
        String days = editRemainderDays.getText().toString();
        try {
            int daysInInteger = Integer.parseInt(days);
            if(daysInInteger <= 0) throw new IllegalArgumentException();
            return daysInInteger;
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "Not a valid remainder days", Toast.LENGTH_SHORT);
            return -1;
        }
    }
}
