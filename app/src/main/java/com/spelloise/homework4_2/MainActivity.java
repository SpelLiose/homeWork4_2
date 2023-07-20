package com.spelloise.homework4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText id, mestoOtpravleniya, vremyaOtpravleniya, mestoPribitiya, vremyaPribitiya;
    private TextView stoimost;
    private Button button;

    private int idIn;
    private int stoimos = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        mestoOtpravleniya = findViewById(R.id.mestoOtpravleniya);
        vremyaOtpravleniya = findViewById(R.id.vremyaOtpravleniya);
        mestoPribitiya = findViewById(R.id.mestoPribitiya);
        vremyaPribitiya = findViewById(R.id.vremyaPribitiya);
        stoimost = findViewById(R.id.stoimost);
        button = findViewById(R.id.button);

        stoimost.setText("Стоимость билета " + stoimos + " рублей.");

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            idIn = Integer.parseInt(id.getText().toString());


            Tickets tickets = new Tickets(idIn,mestoOtpravleniya.getText().toString(),
                    vremyaOtpravleniya.getText().toString(),mestoPribitiya.getText().toString(),
                    vremyaPribitiya.getText().toString(),stoimos);


            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);


            intent.putExtra(Tickets.class.getSimpleName(),tickets);


            startActivity(intent);
        }
    };
}