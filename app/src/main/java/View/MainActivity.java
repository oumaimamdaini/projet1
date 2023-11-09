package View;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private TextView tvAge,tvReponse;
    private RadioButton rb1,rb2;
    private SeekBar sk;
    private Button bt;

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
                calculer(v);
            }
        });

    }
    public void calculer(View view){
    Log.i("Information","button cliqué");
        int age;
        float valeurMesuree;
        boolean verifAge = false, verifValeur = false;
        if(sk.getProgress()!=0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",
                    Toast.LENGTH_SHORT).show();
        if(!et.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();
        if(verifAge && verifValeur) {
            age = sk.getProgress();
            valeurMesuree = Float.valueOf(et.getText().toString());
            boolean isFasting = rb1.isChecked();
            if (isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                }
            } else {
                if (valeurMesuree > 10.5)
                    tvReponse.setText("Niveau de glycémie est trop élevé");
                else
                    tvReponse.setText("Niveau de glycémie est normale");
            }}}
            private void init() {

                et = findViewById(R.id.vm);
                tvAge = findViewById(R.id.votreAge);
                rb1 = findViewById(R.id.rbtOui);
                rb2 = findViewById(R.id.rbtNon);
                sk = findViewById(R.id.sbAge);
                bt = findViewById(R.id.btn);
            }


        }