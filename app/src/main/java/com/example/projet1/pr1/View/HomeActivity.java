package com.example.projet1.pr1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet1.R;
import com.example.projet1.pr1.Controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);  // Corrected method name
                finish();
            }
        });
    }
    private void init()
    {
        loginController = LoginController.getinstance(HomeActivity.this);
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        etPassword = (EditText) findViewById(R.id.mdp);
        etUserName = (EditText) findViewById(R.id.nom);
    }
}

