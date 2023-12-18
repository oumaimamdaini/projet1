package com.example.projet1.pr1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet1.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse;
    private String reponse;

   private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
          init();
        Intent intent = getIntent();
        reponse = intent.getStringExtra("reponse");
        tvReponse.setText(reponse);
            button1 = findViewById(R.id.btnReturn);
            button1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ConsultActivity.this, MainActivity.class);
                   // startActivity(intent);  // Corrected method name
                  //  finish();
                    if(reponse != null)
                    {
                        setResult(RESULT_OK,intent);
                    }
                    else
                    {
                        setResult(RESULT_CANCELED,intent);
                    }
                    finish();
                }
            });

    }
    private void init() {
        tvReponse = findViewById(R.id.tvReponse);
        button1 = findViewById(R.id.btnReturn);
    }
}