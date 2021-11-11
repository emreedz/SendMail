package com.emre.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText baslik;
    EditText icerik;
    Button gonder;


    String userText;
    String baslikText;
    String icerikText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        Gonder();
    }

    public void tanimla() {
        user = findViewById(R.id.user);
        baslik = findViewById(R.id.baslik);
        icerik = findViewById(R.id.icerik);
        gonder = findViewById(R.id.gonder);


    }

    public void bilgiAl() {
        userText = user.getText().toString();
        baslikText = baslik.getText().toString();
        icerikText = icerik.getText().toString();
    }

    public void Gonder() {
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgiAl();

                if (userText.equals("") || baslikText.equals("") || icerikText.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Başlık,Konu ve Mesaj içerikleri gir", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, userText);  //new String[]{alici,baslikk,mesaj} bu şekilde tanımlarsak birden fazla mail gönderebiliriz
                    intent.putExtra(Intent.EXTRA_SUBJECT, baslikText);
                    intent.putExtra(Intent.EXTRA_TEXT, icerikText);
                    startActivity(Intent.createChooser(intent, "Mail Gonder"));
                }


            }
        });
    }


}