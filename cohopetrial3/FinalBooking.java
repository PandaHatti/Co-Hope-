package com.example.cohopetrial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalBooking extends AppCompatActivity {

    private Button Bookbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_booking);


        Bookbtn =(Button) findViewById(R.id.Bookbtn);

        Bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmPage();
            }
        });


    }

    public void  openConfirmPage()
    {
        Intent intent = new Intent(this, ConfirmPage.class);
        startActivity(intent);
    }
}