package com.amani.gestioncafee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button signin;
private Button signup;
private TextView Username;
private TextView Password;
    DataBAseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // remove title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();


        Handler mHandler;
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {


            }

        }, 3000L);/*

        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,accueil.class);
                startActivity(intent);
            }
        });*/
        signin=findViewById(R.id.signin);
        signin.setOnClickListener( new  View.OnClickListener() {
            @Override
            public  void onClick(View v)
            {
                db=new DataBAseHandler(MainActivity.this, null, null, 2);
                Username=findViewById(R.id.Username);
                Password=findViewById(R.id.password);
                String username=Username.getText().toString();
                String password= Password.getText().toString();

                String StoredPassword =db.getsignup(username);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(), StoredPassword+"Login Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), accueil.class));

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    Username.setText("");
                    Password.setText("");
                }
            }

        }
                );
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,signup.class);
                startActivity(intent);


            }
        });




    }


}

