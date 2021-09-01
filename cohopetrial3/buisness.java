package com.example.cohopetrial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class buisness extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button Bookvacc;
    private ImageButton backvacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buisness);


        Spinner spinner= findViewById(R.id.Timespin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Timevaccine, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Spinner spin= findViewById(R.id.Datespin);
        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.Datevaccine, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapt);
        spin.setOnItemSelectedListener(this);

        Spinner Hosp= findViewById(R.id.Vaccinepref);
        ArrayAdapter<CharSequence> hsp = ArrayAdapter.createFromResource(this, R.array.Vaccinepref, android.R.layout.simple_spinner_item);
        hsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Hosp.setAdapter(hsp);
        Hosp.setOnItemSelectedListener(this);


        Bookvacc = (Button) findViewById(R.id.Bookvacc);
        Bookvacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmPage();
            }
        });

        backvacc = (ImageButton) findViewById(R.id.backvacc);
        backvacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openindex_page();
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

    public void openConfirmPage()
    {
        Intent intent = new Intent(this, ConfirmPage.class);
        startActivity(intent);
    }

    public void openindex_page()
    {
        Intent intent = new Intent(this, index_page.class);
        startActivity(intent);
    }


}