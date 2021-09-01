package com.example.cohopetrial3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cohopetrial3.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {
//    //setting upfore real time database
//    ActivityMainBinding binding;
//    FirebaseDatabase db;
//    DatabaseReference reference;
//    String name,phone,email,age;

   // private FirebaseAuth mAuth;
    private Button backbtn;
    EditText namebox, phoneno, emailbox,  Agebox,regbtn;
   private  Button submitbtn;
   String PhonePattern ="[+]+[0-9]";
    String EmailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        //authentication
        namebox = findViewById(R.id.namebox);
        phoneno = findViewById(R.id.phoneno);
        emailbox = findViewById(R.id.emailbox);
        Agebox = findViewById(R.id.Agebox);
        submitbtn = findViewById(R.id.submitbtn);
        progressDialog=new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser =mAuth.getCurrentUser();

//        //realtime database settings
//        binding =ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());





//back to cover page
        backbtn = (Button) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIntroPage();
            }
        });

////after submit.. authentication get started
       submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                    UsersReg usersReg = new UsersReg(name,phone,email,age);
//                    db=FirebaseDatabase.getInstance();
//                    reference=db.getReference("UsersReg");
//                    reference.child(String.valueOf(namebox)).setValue(usersReg).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull  Task<Void> task) {
//
//
//                        }
//                    });

                PerforAuth();

            }
        });

    }


    private void PerforAuth() {
        String name = namebox.getText().toString();
        String phone = phoneno.getText().toString();
        String email = emailbox.getText().toString();
        String age = Agebox.getText().toString();

        if(name.isEmpty())
        {
            namebox.setError("Required");
        }

        if(phone.isEmpty() || !phone.matches(PhonePattern) )
        {
            phoneno.setError("Required/ Error");
        }
        if(email.isEmpty() || !email.matches(EmailPattern))
        {
            emailbox.setError("Required/ Error");
        }
        if(age.isEmpty())
        {
            Agebox.setError("Required");
        }
        else
        {
            progressDialog.setMessage("Please Waite");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,phone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                  if(task.isSuccessful())
                  {
                      progressDialog.dismiss();
                      sendUserToNextActivity();
                      Toast.makeText(RegisterPage.this, "Successful", Toast.LENGTH_LONG).show();

                  }
                  else{
                      progressDialog.dismiss();
                      Toast.makeText(RegisterPage.this,"error "+task.getException(), Toast.LENGTH_LONG).show();


                  }
                }
            });


        }

    }



//sending them to new activity .. that is the login page
private void sendUserToNextActivity()
{
    Intent intent=new Intent(RegisterPage.this,LoginPage.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
}

//for back button
    public void openIntroPage()
    {
        Intent intent = new Intent(this, IntroPage.class);
        startActivity(intent);
    }

}




