package com.amani.gestioncafee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.view.MenuItem;



public class ListeMenu extends AppCompatActivity {

    private RecyclerView recyclerViewMenu;
    private RecyclerView.LayoutManager layoutManager;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_menu);
        Intent intent = getIntent();
        List<Menu> listeMenus = new ArrayList<Menu>();
        if (intent != null) {


            if (intent.hasExtra("mess")) {
                String res = intent.getStringExtra("mess");

                if( res.equals("COFFEE"))
                {
                    listeMenus= Menu.getAllCaffee();

                }
                else
                {
                    if( res.equals("BREAKFAST"))
                    {
                        listeMenus= Menu.getAllBrekfest();

                    }
                    else
                    {
                        if( res.equals("DESERT"))
                        {
                            listeMenus= Menu.getAllDisert();

                        }
                        else
                        {
                            if( res.equals("DRINKS"))
                            {
                                listeMenus= Menu.getAllDrinke();

                            }
                        }
                    }
                }

            }
        }

       /* List<Menu> listeMenus = new ArrayList<Menu>();
        Menu m=new Menu("Caffee Turk","2500",R.drawable.aa);
        listeMenus.add(m);
        m=new Menu("Cafffe Direct","1500",R.drawable.a);
        listeMenus.add(m);*/
        // On récupère notre RecyclerView via son id
        recyclerViewMenu = findViewById(R.id.menu_recyclerview);

        // On veut un RecyclerView qui utilise un LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);

        // On donne notre adapter à notre RecyclerView
        menuAdapter = new MenuAdapter(listeMenus);
        recyclerViewMenu.setAdapter(menuAdapter);

        // On sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewMenu.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewMenu.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;}

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
                Intent intent=new  Intent(ListeMenu.this,welcome.class);
                startActivity(intent);
                return true;



        }
        return super.onOptionsItemSelected(item);
    }
    }
