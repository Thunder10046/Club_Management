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

public class MainActivity2 extends AppCompatActivity {

    private EditText password, email, username;
    private Button login;
    private TextView already1;
    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        login = findViewById(R.id.signup);
        already1 = findViewById(R.id.already1);
        imageview1 = findViewById(R.id.imageView1);

//        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
//        {
//            Intent intent = new Intent(getApplicationContext(), Friendactivity.class);
//            startActivity(intent);
//            finish();
//        }

        already1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "Invalid Inpput !", Toast.LENGTH_SHORT).show();
                }
                loginhandler();
            }
        });
    }

    private void loginhandler(){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity2.this, "Sign in is Successful !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Friendactivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity2.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}