package com.example.clubmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText signupname,signuproll, signupdepartment,signupemail,signup_nick_name, signupbkash;
    Button register;
    TextView loginRedirectText;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupname = findViewById(R.id.signup_name);
        signuproll = findViewById(R.id.signup_roll);
        signupdepartment = findViewById(R.id.signup_department);
        signupemail = findViewById(R.id.signup_email);
        signup_nick_name = findViewById(R.id.signup_nick_name);
        signupbkash = findViewById(R.id.signup_bkash);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = signupname.getText().toString();
                String roll = signuproll.getText().toString();
                String department = signupdepartment.getText().toString();
                String email = signupemail.getText().toString();
                String lastname = signup_nick_name.getText().toString();
                String bkash = signupbkash.getText().toString();

                User_helper helper = new User_helper(name,lastname, roll,department,email,bkash);

//                FirebaseDatabase.getInstance().getReference("Users"+FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(helper);

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Users");

                reference.child(lastname).setValue(helper);

                Toast.makeText(Register.this, "Registration has been successgul! ", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Register.this, Friendactivity.class);
                startActivity(intent);


            }
        });
    }
}

