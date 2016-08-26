/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

        // Find the View that shows the numbers category
        TextView listen = (TextView) findViewById(R.id.listen);

        if (listen != null) {
            listen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent numbersIntent = new Intent(MainActivity.this, ListenActivity.class);
                    startActivity(numbersIntent);
                }
            });
        }

        // Find the View that shows the colors category
        TextView topCharts = (TextView) findViewById(R.id.topCharts);

        if (topCharts != null) {
            topCharts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent colorsIntent = new Intent(MainActivity.this, TopChartsActivity.class);
                    startActivity(colorsIntent);
                }
            });
        }

        // Find the View that shows the phrases category
        TextView library = (TextView) findViewById(R.id.library);

        if (library != null) {
            library.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent phrasesIntent = new Intent(MainActivity.this, LibraryActivity.class);
                    startActivity(phrasesIntent);
                }
            });
        }

        // Find the View that shows the family category
        TextView shop = (TextView) findViewById(R.id.shop);

        if (shop != null) {
            shop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent familyIntent = new Intent(MainActivity.this, ShopActivity.class);
                    startActivity(familyIntent);
                }
            });
        }
    }


}

