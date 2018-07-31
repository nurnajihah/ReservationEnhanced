package sg.edu.rp.c346.reservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvPhone;
    TextView tvSize;
    EditText etName;
    EditText etPhone;
    EditText etSize;
    CheckBox checkBox;
    TextView tvDay;
    EditText etDay;
    TextView tvTime;
    EditText etTime;
    Button buttonReserve;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.textViewName);
        tvPhone = findViewById(R.id.textViewPhone);
        tvSize = findViewById(R.id.textViewSizeOfGroup);
        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextSizeOfGroup);
        checkBox = findViewById(R.id.checkBox);
        buttonReserve = findViewById(R.id.buttonReserve);
        buttonReset = findViewById(R.id.buttonReset);
        tvDay = findViewById(R.id.editTextDay);
        etDay = findViewById(R.id.editTextDay);
        tvTime = findViewById(R.id.textViewTime);
        etTime = findViewById(R.id.editTextTime);

        //DatePicker
        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        etDay.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });

        //TimePicker
        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
                        etTime.setText("Time: " + hourOfDay + ":" + minuteOfHour);
            }
        };

                Date time = Calendar.getInstance().getTime();
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, time.getHours(), time.getMinutes(), true);
                myTimeDialog.show();
            }
        });

        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Confirm Your Order");
                String smoking = "";
                if (checkBox.isChecked())   {
                    smoking = "Yes";
                }
                else    {
                    smoking = "No";
                }
                myBuilder.setMessage("New Reservation" + "\n" + "Name: " + etName.getText().toString() + "\n" + "Smoking: " + smoking + "\n" + "Size: " + etSize.getText().toString() + "\n" + etDay.getText().toString() + "\n" + etTime.getText().toString());
                myBuilder.setCancelable(false);
                myBuilder.setNegativeButton("Cancel", null);
                myBuilder.setPositiveButton("Confirm", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });




        //reset button
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etPhone.setText("");
                etSize.setText("");
                etDay.setText("");
                etTime.setText("");
                if (checkBox.isChecked())   {
                    checkBox.setChecked(false);
                }

            }
        });


    }
}
