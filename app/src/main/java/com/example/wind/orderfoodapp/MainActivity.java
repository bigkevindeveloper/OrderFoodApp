package com.example.wind.orderfoodapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp, btnSignIn;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        txtSlogan = (TextView)findViewById(R.id.txtSlogan);
        Typeface nabilaFont = Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");

        txtSlogan.setTypeface(nabilaFont);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Iniciar Sesión",Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(),SignIn.class);
                startActivity(I);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Registrarse",Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(),SignUp.class);
                startActivity(I);
            }
        });

    }
}
