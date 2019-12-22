package com.amani.gestioncafee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class accueil extends AppCompatActivity {
    private Button cofee;
    private Button BREAKFAST;
    private Button DRINKS;
    private  Button DESERT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        cofee=findViewById(R.id.COFFEE);
        cofee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(accueil.this,ListeMenu.class);
                intent.putExtra("mess", "COFFEE");
                startActivity(intent);




            }
        });

        BREAKFAST=findViewById(R.id.BREAKFAST);
        BREAKFAST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(accueil.this,ListeMenu.class);
                intent.putExtra("mess", "BREAKFAST");
                startActivity(intent);




            }
        });
        DRINKS=findViewById(R.id.DRINKS);
        DRINKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(accueil.this,ListeMenu.class);
                intent.putExtra("mess", "DRINKS");
                startActivity(intent);




            }
        });
        DESERT=findViewById(R.id.DESERT);
        DESERT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(accueil.this,ListeMenu.class);
                intent.putExtra("mess", "DESERT");
                startActivity(intent);




            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Français:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.Anglais:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.se_décoonecter:
                onDestroy();
                Intent intent=new  Intent(accueil.this,welcome.class);
                startActivity(intent);
                return true;



        }
        return super.onOptionsItemSelected(item);
    }
}
