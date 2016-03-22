package com.bordertextviewsample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yakirp.BorderTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BorderTextView borderTextView = (BorderTextView) findViewById(R.id.BorderTextView);

        borderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BorderTextView","BorderTextView");
                borderTextView.setText("sdfsdfdsfdsf");
                borderTextView.setColor(Color.BLUE);
            }
        });



    }
}
