package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.aqsa.rasmenu.Join.ArrayAccount;
import com.aqsa.rasmenu.models.AdditionArray;

import org.w3c.dom.Text;

public class sign_in extends AppCompatActivity {

    boolean remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        EditText UserName = findViewById(R.id.edUserName);
        EditText Password = findViewById(R.id.edPassword);
        CheckBox cb = findViewById(R.id.check);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remember = cb.isChecked();
            }
        });

        Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Password.setText(getPassword(UserName.getText().toString()));
            }
        });

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(UserName.getText().toString(), Password.getText().toString(), remember);
            }
        });

    }


    public void search(String UserName, String pass, boolean remember) {
        if (ArrayAccount.getAccount().size() == 0) {
            Toast.makeText(this,
                    "There is no Accounts Added yet\n" +
                            "Join us to be our first client", Toast.LENGTH_SHORT).show();
        } else if (Exist(UserName) && match(UserName, pass)) {
            ArrayAccount.getAccount().get(Index(UserName)).setRemember(remember);
            Toast.makeText(this, "welcome Sir. at our Restaurant", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), main_categories.class);
            startActivity(intent);
        } else
            Toast.makeText(this, "Error entry", Toast.LENGTH_SHORT).show();
    }

    public boolean Exist(String UserName) {
        for (int i = 0; i < ArrayAccount.getAccount().size(); i++)
            if (ArrayAccount.getAccount().get(i).getUsername().equals(UserName))
                return true;
        return false;
    }

    public int Index(String Username) {
        if (Exist(Username))
            for (int i = 0; i < ArrayAccount.getAccount().size(); i++)
                if (ArrayAccount.getAccount().get(i).getUsername().equals(Username))
                    return i;
        return 0;
    }

    public boolean isRemember(String Usernamr) {
        if (Exist(Usernamr))
            if (ArrayAccount.getAccount().get(Index(Usernamr)).isRemember())
                return true;
        return false;
    }

    public boolean match(String username, String pass) {
        for(int i=0;i<ArrayAccount.getAccount().size();i++)
            if(ArrayAccount.getAccount().get(Index(username)).getPassowrd().equals(pass) &&
                ArrayAccount.getAccount().get(Index(username)).getUsername().equals(username))
                return true;
        return false;
    }

    public String getPassword(String Username) {
        if (Exist(Username)&&ArrayAccount.getAccount().get(Index(Username)).isRemember())
            return ArrayAccount.getAccount().get(Index(Username)).getPassowrd();
        return "";
    }

}