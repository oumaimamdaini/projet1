package com.example.projet1.pr1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet1.R;

import com.example.projet1.pr1.Controller.Controller;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1;
    private EditText et;
    private TextView tvAge,tvReponse;
    private RadioButton rb1,rb2;
    private SeekBar sk;
    private Button bt;
    private Controller controller= Controller.getinstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Changement du SeekBar", "onProgressChanged " + progress);
                // affichage dans le Log de Android studio pour voir le changements détectés sur le SeekBar ..
                tvAge.setText("Votre âge : " + progress);
                // Mise à jour du TextView par la valeur : progress à chaque changement.
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");

                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;

                if(sk.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age !", Toast.LENGTH_SHORT).show();

                if(!et.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();

                if(verifAge && verifValeur)
                {
                    age = sk.getProgress();
                    valeurMesuree = Float.valueOf(et.getText().toString());

                    //Flèche "User action" Vue --> Controller
                    controller.createPatient(age, valeurMesuree, rb1.isChecked());

                    //Flèche "Update" Controller --> vue

                    Intent intent = new Intent (MainActivity.this, ConsultActivity.class);
                    intent.putExtra("reponse",controller.getResult());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }
            private void init() {

                et = findViewById(R.id.vm);
                tvAge = findViewById(R.id.votreAge);
                rb1 = findViewById(R.id.rbtOui);
                rb2 = findViewById(R.id.rbtNon);
                sk = findViewById(R.id.sbAge);
                bt = findViewById(R.id.btn);
            }


        }