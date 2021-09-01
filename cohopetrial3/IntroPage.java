package com.example.cohopetrial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.channels.AsynchronousServerSocketChannel;

public class IntroPage extends AppCompatActivity {
    private Button registerbtn;
    private Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

       registerbtn =(Button) findViewById(R.id.registerbtn);
        loginbtn =(Button) findViewById(R.id.loginbtn);
       registerbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openRegisterPage();
           }
       });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });


    }

    public void openRegisterPage()
    {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

   public void openLoginPage()
    {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}