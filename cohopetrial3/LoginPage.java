package com.example.cohopetrial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AppCompatActivity {

    //for back button to home page
    private ImageButton backloginbutton;

    // phone nymber authentication and verification
    EditText Countrycode, phoneNumber , Verifyotp;
    Button Genratebtn, verifybtn, Restbtn;
    String Userphnumber,verificationId;
    PhoneAuthProvider.ForceResendingToken token;
    FirebaseAuth fAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //otp authentication and verification

        Countrycode=findViewById(R.id.cCode);
        phoneNumber=findViewById(R.id.phnumber);
        Genratebtn=findViewById(R.id.Genotp);

        Verifyotp=findViewById(R.id.verifyotp);
        verifybtn=findViewById(R.id.verifybtn);
        Restbtn=findViewById(R.id.resetbtn);
        fAuth = FirebaseAuth.getInstance();
        Restbtn.setEnabled(false);

        Genratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(Countrycode.getText().toString().isEmpty())
              {
                  Countrycode.setError("Required");
                  return;
              }if (phoneNumber.getText().toString().isEmpty())
                {
                    phoneNumber.setError("Required");
                    return;
                }
              Userphnumber="+"+Countrycode.getText().toString()+phoneNumber.getText().toString();
              verifyphonenumber(Userphnumber);
                Toast.makeText(LoginPage.this,Userphnumber,Toast.LENGTH_SHORT);
            }
        });

        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull  PhoneAuthCredential phoneAuthCredential) {
                      Authenticateuseer(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(LoginPage.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull  String s, @NonNull  PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId=s;
                token=forceResendingToken;

                //visibility of the generation is gone
                Countrycode.setVisibility(View.GONE);
                phoneNumber.setVisibility(View.GONE);
                Genratebtn.setVisibility(View.GONE);

                //visibility of verification is visible
                Verifyotp.setVisibility(View.VISIBLE);
                verifybtn.setVisibility(View.VISIBLE);
                Restbtn.setVisibility(View.VISIBLE);
                Restbtn.setEnabled(true);




            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                Restbtn.setEnabled(false);
            }
        };
        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Verifyotp.getText().toString().isEmpty())
                {
                    Verifyotp.setError("Enter OTP First");
                    return;
                }
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,Verifyotp.getText().toString());
                Authenticateuseer(credential);
            }
        });

//back to the intro page
        backloginbutton = (ImageButton) findViewById(R.id.backloginbutton);
        backloginbutton = findViewById(R.id.backloginbutton);
        backloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIntroPage();
            }
        });


    }
    //for back button
    public void openIntroPage()
    {
        Intent intent = new Intent(this, IntroPage.class);
        startActivity(intent);
    }

    //verify
    public void verifyphonenumber(String phoneNum)
    {
        //send OTP
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(fAuth)
                .setActivity(this)
                .setPhoneNumber(phoneNum)
        .setTimeout(60L,TimeUnit.SECONDS)
                .setCallbacks(callbacks)
                .build();

       PhoneAuthProvider.verifyPhoneNumber(options);

    }
    public void Authenticateuseer(PhoneAuthCredential credential)
    {

        fAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {

            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginPage.this,"Success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),index_page.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginPage.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
    }






