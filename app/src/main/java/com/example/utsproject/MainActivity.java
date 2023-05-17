package com.example.utsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button tbMasukLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMasukLogin = (Button) findViewById(R.id.btMasukLogin );
        tbMasukLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {MasukLoginOnClick();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this.getBaseContext(), "Terimakasih",
                Toast.LENGTH_LONG).show();
    }

    public void MasukLoginOnClick() {
        Intent halamanRegis=new Intent(this, halLogin.class);
        startActivity(halamanRegis);
    }
}