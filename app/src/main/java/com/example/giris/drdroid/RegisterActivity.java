package com.example.giris.drdroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "Login Credentials";

    MaterialEditText firstName;
    MaterialEditText lastName;
    MaterialEditText age;
    MaterialEditText email;
    MaterialEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = (MaterialEditText)findViewById(R.id.firstname);
        lastName = (MaterialEditText)findViewById(R.id.lastname);
        age = (MaterialEditText)findViewById(R.id.age);
        email = (MaterialEditText)findViewById(R.id.email);
        password = (MaterialEditText)findViewById(R.id.password);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String f = firstName.getText().toString();
                String l = lastName.getText().toString();
                String a = age.getText().toString();
                String e = email.getText().toString();
                String p = password.getText().toString();
                if(f.equals("") || l.equals("") || a.equals("") || e.equals("") || p.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //TODO: add post request and finish activity and shared pref to go into success of call

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("firstname", f);
                    editor.putString("lastname", l);
                    editor.putString("age", a);
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
