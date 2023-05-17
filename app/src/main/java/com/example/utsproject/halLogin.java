package com.example.utsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class halLogin extends AppCompatActivity {
    Button tombolLogin;
    EditText idBar;
    EditText pwBar;
    MediaPlayer suara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_login);

        idBar = (EditText) findViewById(R.id. idBar);
        pwBar = (EditText) findViewById(R.id. pwBar);

        tombolLogin = (Button) findViewById(R.id. tombolLogin );
        tombolLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loginDiklik();
            }
        });
        Spinner Bahasa = (Spinner)findViewById(R.id.pilihanBhs);
//Daftar isian spninner yang tampil
        String[] pilihanBahasa = {
                "English", "Indonesia", "Jawa" };
//Mengubah arr mj ArrAdapter
        ArrayAdapter<String> arrayAdapterBahasa = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, pilihanBahasa);
//Memasukkan ArrAdapater ke spinner
        Bahasa.setAdapter(arrayAdapterBahasa);
    }
    public void loginDiklik() {
        String user , pw ;
        user = idBar.getText().toString();
        pw = pwBar.getText().toString();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String newuser= SP.getString("newID", "admin");
        String newpass0= SP.getString("newPass","admin");

        if (user.equals(newuser) && pw.equals(newpass0)){

            Intent halamanPembuka=new Intent(this, halHasil.class);

            Bundle data = new Bundle();
            data.putString("USER",user);
            halamanPembuka.putExtras(data) ;

            startActivity(halamanPembuka);
            suara = MediaPlayer.create(halLogin.this,R.raw.login_berhasil);
            suara.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    suara.start();
                }
            });
            suara.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    suara.release();
                }
            });
        }
        else{
            Toast.makeText(this.getBaseContext(), "Maaf, User atau Password yang kamu masukan salah.",Toast.LENGTH_SHORT).show();
        }

    }
}