package com.spelloise.homework4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView info;
    private Button button2;

    private Tickets tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        info = findViewById(R.id.info);
        button2 = findViewById(R.id.button2);

        Bundle bundleTickets = getIntent().getExtras();

        if (bundleTickets != null) {
            tickets = (Tickets) bundleTickets.getSerializable(Tickets.class.getSimpleName());
            info.setText(tickets.toString());
        }

        button2.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivity(intent);

        }
    };
}