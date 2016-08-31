package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.miwok.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file5
        setContentView(R.layout.activity_main);

        // Find the View that shows the Listen category
        TextView listen = (TextView) findViewById(R.id.listen);

        if (listen != null) {
            listen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent listenIntent = new Intent(MainActivity.this, ListenActivity.class);
                    startActivity(listenIntent);
                }
            });
        }

        // Find the View that shows the Top charts category
        TextView topCharts = (TextView) findViewById(R.id.topCharts);

        if (topCharts != null) {
            topCharts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent topChartsIntent = new Intent(MainActivity.this, TopChartsActivity.class);
                    startActivity(topChartsIntent);
                }
            });
        }

        // Find the View that shows the library category
        TextView library = (TextView) findViewById(R.id.library);

        if (library != null) {
            library.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent libraryIntent = new Intent(MainActivity.this, LibraryActivity.class);
                    startActivity(libraryIntent);
                }
            });
        }
        // Find the View that shows the shop category
        TextView shop = (TextView) findViewById(R.id.shop);
        if (shop != null) {
            shop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent shopIntent = new Intent(MainActivity.this, ShopActivity.class);
                    startActivity(shopIntent);
                }
            });
        }
    }
}

