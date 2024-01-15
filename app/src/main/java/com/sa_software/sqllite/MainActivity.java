package com.sa_software.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputEditText ed_username,ed_phone_number;
    Button submit_btn;

    data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit_btn=findViewById(R.id.submit_btn);
        ed_username=findViewById(R.id.ed_username);
        ed_phone_number=findViewById(R.id.ed_phone_number);
        data=new data(MainActivity.this);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUserName() | !validatePhoneNumber()) {
                    return;
                }

               /* new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Hello deyar")
                        .setMessage("How can help you sohid")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "No ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();
*/

                String name = ed_username.getText().toString().trim();
                String phone = ed_phone_number.getText().toString().trim();
               data.input(name,phone);


            }
        });




    }//========================On Create Matho end here

    private boolean validateUserName() {
        String val = ed_username.getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            ed_username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            ed_username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            ed_username.setError("No white spaces are allowed! ");
            return false;
        } else {
            ed_username.setError(null);
            ed_username.setEnabled(false);
            return true;
        }
    }//===============

    private boolean validatePhoneNumber() {
        String val = ed_phone_number.getText().toString().trim();

        if (val.length()!=11) {
            ed_phone_number.setError("Enter valid phone number");
            return false;
        } else {
            ed_phone_number.setError(null);
            ed_phone_number.setEnabled(false);
            return true;
        }
    }






}//====================Publich clsaaa end here