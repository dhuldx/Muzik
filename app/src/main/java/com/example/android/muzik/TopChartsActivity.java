package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.miwok.R;

public class TopChartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_charts);

        // Find the View that shows the Top charts category
        TextView play = (TextView) findViewById(R.id.play);
        if (play != null) {
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent topChartsIntent = new Intent(TopChartsActivity.this, ListenActivity.class);
                    startActivity(topChartsIntent);
                }
            });
        }
    }
}
