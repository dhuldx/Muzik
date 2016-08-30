package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.miwok.R;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        // Find the View that shows the family category
        TextView buy = (TextView) findViewById(R.id.buy);

        if (buy != null) {
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent familyIntent = new Intent(ShopActivity.this, PaymentActivity.class);
                    startActivity(familyIntent);
                }
            });
        }
    }
}


