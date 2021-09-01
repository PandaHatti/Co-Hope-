package com.example.cohopetrial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SlotBooking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button nextslotbtn;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_booking);


        
        
        Spinner spinner= findViewById(R.id.DateSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dates, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Spinner spin= findViewById(R.id.TimeSpinner);
        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.times, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapt);
        spin.setOnItemSelectedListener(this);

        Spinner Hosp= findViewById(R.id.Hospspinner);
        ArrayAdapter<CharSequence> hsp = ArrayAdapter.createFromResource(this, R.array.hospitals, android.R.layout.simple_spinner_item);
        hsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Hosp.setAdapter(hsp);
        Hosp.setOnItemSelectedListener(this);



        nextslotbtn = (Button) findViewById(R.id.nextslotbtn);
        nextslotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinalBooking();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openFinalBooking()
    {
        Intent intent = new Intent(this, FinalBooking.class);
        startActivity(intent);
    }
}

