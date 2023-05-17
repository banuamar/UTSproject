package com.example.utsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class halHasil extends AppCompatActivity {

    Button simpan;
    EditText newPw0, newPw1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_hasil);

        Bundle data = getIntent().getExtras();
        String user = data.getString("USER");

        TextView salam = findViewById(R.id.salam);
        salam.setText(user+", Login Berhasil !!");

        simpan = (Button) findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {saveDiklik();}
        });
    }
    public void saveDiklik() {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor edit = SP.edit();

        String newpass1 = ((EditText)findViewById(R.id.newPw1)).getText().toString();
        String newpass2 = ((EditText)findViewById(R.id.newPw2)).getText().toString();

        if (!newpass1 .equals(newpass2)) {
            Toast.makeText(this.getBaseContext(),"Maaf, Password salah / tidak sama", Toast.LENGTH_LONG).show();
            return;
        }

        edit.putString("newPass", newpass1);

        edit.commit(); //simpan

        Toast.makeText(this.getBaseContext(), "Berhasil menyimpan data", Toast.LENGTH_SHORT).show();
    }
}