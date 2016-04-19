package com.example.giris.drdroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.Button;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public static final String MY_PREFS_NAME = "Login Credentials";

    MaterialEditText name;
    MaterialEditText phone;
    MaterialEditText age;
    MaterialEditText email;
    MaterialEditText password;
    int year, month, day;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (MaterialEditText)findViewById(R.id.firstname);
        phone = (MaterialEditText)findViewById(R.id.phone);
        dateButton = (Button)findViewById(R.id.dateButton);
        email = (MaterialEditText)findViewById(R.id.email);
        password = (MaterialEditText)findViewById(R.id.password);

        // Show a datepicker when the dateButton is clicked
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        RegisterActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Date of Birth");
            }
        });

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String f = name.getText().toString();
                String l = phone.getText().toString();
                //String a = age.getText().toString();
                String e = email.getText().toString();
                String p = password.getText().toString();
                if(f.equals("") || l.equals("") ||  e.equals("") || p.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //TODO: add post request and finish activity and shared pref to go into success of call

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("name", f);
                    editor.putString("phone", l);
                    editor.putInt("year", year);
                    editor.putInt("month", month);
                    editor.putInt("day", day);
                    editor.putString("email", e);
                    editor.putString("password", p);
                    editor.commit();
                    startActivity(new Intent(RegisterActivity.this, NavActivity.class));
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        month = monthOfYear+1;
        day = dayOfMonth;
        dateButton.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
