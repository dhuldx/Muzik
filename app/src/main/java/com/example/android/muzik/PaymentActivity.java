package com.example.android.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        TextView submit = (TextView) findViewById(R.id.submit);

        if (submit != null) {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent paymentIntent = new Intent(PaymentActivity.this, MainActivity.class);
                    Toast.makeText(PaymentActivity.this,"Payment Successful !! Listen to music now", Toast.LENGTH_SHORT).show();
                    startActivity(paymentIntent);

                }
            });
        }

    }
}
