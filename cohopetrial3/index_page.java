package com.example.cohopetrial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class index_page extends AppCompatActivity {
    private ImageButton backindexbtn;
    private Button slotbtnindex;
    private Button buisnessbtn;


    //login Authentication
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

        //authentication for login
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();

//back button for the intro page
        backindexbtn = (ImageButton) findViewById(R.id.backindexbtn);

        backindexbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIntroPage();
            }
        });
//slotbooking button
        slotbtnindex = (Button) findViewById(R.id.slotbtnindex);

        slotbtnindex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSlotBooking();
            }
        });
//vaccination drive button
        buisnessbtn = (Button) findViewById(R.id.buisnessbtn);

        buisnessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuisness();
            }
        });



    }

//class for back button to the intro page
        public void openIntroPage()
        {
            Intent intent = new Intent(this, IntroPage.class);
            startActivity(intent);
        }
//class for slotbooking page
    public void  openSlotBooking()
    {
        Intent intent = new Intent(this, SlotBooking.class);
        startActivity(intent);
    }
//class for vaccination drive
    public void  openbuisness()
    {
        Intent intent = new Intent(this, buisness.class);
        startActivity(intent);
    }
@Override
    protected void onStart() {

        super.onStart();
        if(mCurrentUser ==null)
        {
            Intent loginintent = new Intent(index_page.this, LoginPage.class);
            loginintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            loginintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginintent);
            finish();
        }
    }

}