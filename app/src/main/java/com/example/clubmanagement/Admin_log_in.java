package com.example.clubmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_log_in extends AppCompatActivity {
    private EditText password, email, username;
    private Button login;
    private TextView member_sign, member_log;
    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        login = findViewById(R.id.signup);
        member_sign = findViewById(R.id.sign_up_member);
        member_log = findViewById(R.id.log_in_member);
        imageview1 = findViewById(R.id.imageView1);

//        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
//        {
//            Intent intent = new Intent(getApplicationContext(), Friendactivity.class);
//            startActivity(intent);
//            finish();
//        }

        member_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        member_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(Admin_log_in.this, "Invalid Inpput !", Toast.LENGTH_SHORT).show();
                }
                loginhandler2();
            }
        });
    }

    private void loginhandler2(){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String singleUserEmail = "radauritro@gmail.com";
                    if (email.getText().toString().equals(singleUserEmail)) {
                        Toast.makeText(Admin_log_in.this, "You are proceed to sign in as Admin!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Admin_feed.class);
                        startActivity(intent);
                    } else {
                        // Display an error message if the email doesn't match
                        Toast.makeText(Admin_log_in.this, "Authentication failed. Invalid user.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Admin_log_in.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                email.getText().clear();
                password.getText().clear();
            }
        });


    }

}