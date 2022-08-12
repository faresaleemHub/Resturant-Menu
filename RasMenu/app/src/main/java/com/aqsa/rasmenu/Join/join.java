package com.aqsa.rasmenu.Join;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.aqsa.rasmenu.R;
import com.aqsa.rasmenu.main_categories;
import com.aqsa.rasmenu.sign_in;

import java.util.Calendar;

public class join extends AppCompatActivity {

    EditText fname, username, phone, password1, password2, DOB;
    RadioGroup rg;
    RadioButton male, femal;
    Spinner location;
    Button submit, clear;
    UserAccount user;
    String currentDate="",userDate="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        fname = findViewById(R.id.edfullName);
        username = findViewById(R.id.edUserName);
        phone = findViewById(R.id.edphone);
        rg = findViewById(R.id.rg);
        male = findViewById(R.id.rbmale);
        femal = findViewById(R.id.rbfemale);
        location = findViewById(R.id.spLocation);
        password1 = findViewById(R.id.edpassword1);
        password2 = findViewById(R.id.edpassword2);
        DOB = findViewById(R.id.edDOB);
        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname.setText("");
                username.setText("");
                phone.setText("");
                password1.setText("");
                password2.setText("");
                DOB.setText("");
            }
        });


        DOB.setInputType(InputType.TYPE_NULL);
        DOB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                currentDate=""+year;

                DatePickerDialog picker = new DatePickerDialog(join.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        DOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        userDate=""+year;
                    }
                }, year, month, day);
                picker.setTitle("Choose Date ...");
                picker.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fname, Username, Date, Phone, Gender, Location, Password1, Password2;
                Fname = fname.getText().toString();
                Username = username.getText().toString();
                Phone = phone.getText().toString().trim();//acting as ID
                Gender = male.isChecked() ? "Male" : "Female";
                Location = location.getSelectedItem().toString();
                Password1 = password1.getText().toString();
                Password2 = password2.getText().toString();
                Date = DOB.getText().toString();

                //name
                if (Fname.equals(null) || Fname.equals("")) {
                    fname.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the empty space", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    fname.setBackgroundColor(Color.WHITE);

                String fname2 = Fname.toLowerCase();
                boolean state = true;
                int j = 0;
                int i=0;
                while (state && j < fname2.length()) {
                    if (fname2.charAt(j) < (char) 97 && fname2.charAt(j) != (char) 32 || fname2.charAt(j) > (char) 121)
                        state = false;
                    j++;
                }
                if (!state) {
                    fname.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "the name must contain letters only in English", Toast.LENGTH_LONG).show();
                    return;
                } else
                    fname.setBackgroundColor(Color.WHITE);

                //username
                if (Username.equals(null) || Username.equals("")) {
                    username.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the empty space", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    username.setBackgroundColor(Color.WHITE);

                if (Username.equals(Fname)) {
                    username.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "Username mustn't be equal to your name", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    username.setBackgroundColor(Color.WHITE);

                j = 0;
                state = true;
                String username2=Username.toLowerCase();
                while (state && j < Username.length()) {
                    if (username2.charAt(j) < (char) 97 && username2.charAt(j) != (char) 32 || username2.charAt(j) > (char) 121)
                        state = false;
                    j++;
                }
                if (state) {
                    username.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "UserName must contain at least 1 sympol", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    username.setBackgroundColor(Color.WHITE);

                //phone
                if (Phone.equals(null) || Phone.equals("")) {
                    phone.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the phone empty space", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    phone.setBackgroundColor(Color.WHITE);

                if (Phone.length() != 10) {
                    Toast.makeText(join.this, "the Phone Number must be 10 digits", Toast.LENGTH_SHORT).show();
                    phone.setBackgroundColor(Color.RED);
                    return;
                } else
                    phone.setBackgroundColor(Color.WHITE);

                if (Phone.charAt(0) != '0' && Phone.charAt(1) != '5' && (Phone.charAt(2) != '9' || Phone.charAt(2) != '6')) {
                    Toast.makeText(join.this, "the number must begin wiht 059 or 056", Toast.LENGTH_SHORT).show();
                    phone.setBackgroundColor(Color.RED);
                    return;
                } else
                    phone.setBackgroundColor(Color.WHITE);

                //DateOfBirth
                if (Date.equals(null) || Date.equals("")) {
                    DOB.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the empty DOB space", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    DOB.setBackgroundColor(Color.WHITE);

                if(Integer.parseInt(currentDate)-Integer.parseInt(userDate)<13){
                    DOB.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "your Age must be at least 13 years old", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    DOB.setBackgroundColor(Color.WHITE);

                //password
                if (Password1.equals(null) || Password1.equals("")) {
                    password1.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the empty password space", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    password1.setBackgroundColor(Color.WHITE);

                if (Password1.length() < 8) {
                    password1.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "The Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    password1.setBackgroundColor(Color.WHITE);

                String pass=Password1;
                state=false;
                for(i=0;i<pass.length()-1;i++)
                    for (j=i+1;j<pass.length();j++)
                        if(pass.charAt(i)==pass.charAt(j)) {
                            state = true;
                            break;
                        }
                if(state==true){
                    password1.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "for Secret issues\n" +
                                    "The password should not contain duplicate characters", Toast.LENGTH_LONG).show();
                    return;
                 }else
                     password1.setBackgroundColor(Color.WHITE);

                if(Password1.equalsIgnoreCase(Fname)) {
                    Toast.makeText(join.this, "for Secret issues\n" +
                            "The password should differ from your name", Toast.LENGTH_LONG).show();
                    password1.setBackgroundColor(Color.RED);
                    return;
                }

                if(Password1.equalsIgnoreCase(Username)){
                    Toast.makeText(join.this, "for Secret issues\n" +
                            "The password should differ from your Username", Toast.LENGTH_LONG).show();
                    password1.setBackgroundColor(Color.RED);
                    return;
                }

                if(Password1.equals(Phone)){
                    Toast.makeText(join.this, "for Secret issues\n" +
                            "The password should differ from your Phone No.", Toast.LENGTH_LONG).show();
                    password1.setBackgroundColor(Color.RED);
                    return;
                }
                    
                j=0;
                state=true;
                pass=Password1.toLowerCase();
                while(state&&j<pass.length()){
                    if(pass.charAt(j) < (char)97 && pass.charAt(j)!=(char)32 || pass.charAt(j) > (char)121)
                        state=false;
                    j++;
                }
                if(state){
                    password1.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "for Secret issues\n" +
                            "the password must contain at least 1 sympol", Toast.LENGTH_LONG).show();
                    return;
                }else
                    password1.setBackgroundColor(Color.WHITE);

                if(Password2.equals(null)||Password2.equals("")){
                    password2.setBackgroundColor(Color.RED);
                    Toast.makeText(join.this, "fill the empty password space", Toast.LENGTH_SHORT).show();
                    return;
                }else
                    password2.setBackgroundColor(Color.WHITE);

                if (!Password1.equals(Password2)) {
                    Toast.makeText(join.this, "The two passwords are't the same", Toast.LENGTH_SHORT).show();
                    password1.setBackgroundColor(Color.RED);
                    password2.setBackgroundColor(Color.RED);
                    return;
                }else {
                    password1.setBackgroundColor(Color.WHITE);
                    password2.setBackgroundColor(Color.WHITE);
                }

                user = new UserAccount(Fname, Username, Date, Phone, Gender, Location, Password1);

                for (i = 0; i < ArrayAccount.getAccount().size(); i++)
                    if (ArrayAccount.getAccount().get(i).getUsername().equals(user.getUsername())) {
                        Toast.makeText(join.this, "this UserName has been used befor", Toast.LENGTH_LONG).show();
                        username.setBackgroundColor(Color.RED);
                        return;
                    } else
                        username.setBackgroundColor(Color.WHITE);

                for (i = 0; i < ArrayAccount.getAccount().size(); i++)
                    if (ArrayAccount.getAccount().get(i).getPhone().equals(user.getPhone())) {
                        phone.setBackgroundColor(Color.RED);
                        Toast.makeText(join.this, "this Phone No. has been used befor", Toast.LENGTH_LONG).show();
                        return;
                    }else
                        phone.setBackgroundColor(Color.WHITE);

                    ArrayAccount.setAccount(user);
                    Toast.makeText(join.this, "welcome Sir. at our Restaurant", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), main_categories.class);
                    startActivity(intent);
            }
        });
    }
}