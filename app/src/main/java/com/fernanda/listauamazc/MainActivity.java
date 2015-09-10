package com.fernanda.listauamazc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Declaro mi lista
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relleno mi arreglo
        Octocats octocats_datos[]= new Octocats[]{
            new Octocats(R.mipmap.ic_bouncer,"Bouncer Octocat"),
            new Octocats(R.mipmap.ic_dodger, "Dodger Octocat"),
            new Octocats(R.mipmap.ic_female, "Female Octocat"),
            new Octocats(R.mipmap.ic_filmtocat, "Filmtocat Octocat"),
            new Octocats(R.mipmap.ic_gracehoper, "GraceHoperCat Octocat"),
            new Octocats(R.mipmap.ic_ninja, "NinjaCat Octocat"),
            new Octocats(R.mipmap.ic_pusheen,"PusheenCat Octocat"),
            new Octocats(R.mipmap.ic_rainbow, "RainbowCat Octocat")
        };

        //Al adaptador le paso el contenido del arreglo lleno
        OctocatsAdapter adapter = new OctocatsAdapter(this,R.layout.listview_item_row,octocats_datos);

        //Me traigo mi lista y la enlazo con su vista, ademas le asigno su adaptador lleno
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);

        //Escucho los eventos en los items (elementos de la lista)
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>arg0, View arg1, int arg2, long arg3) {
                TextView v = (TextView)arg1.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
