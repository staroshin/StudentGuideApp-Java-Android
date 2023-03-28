package edu.ewubd.guide;

import android.content.Intent;
import android.database.Cursor;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FeesDetails extends AppCompatActivity {


    TextView fstt1,fstt2,fstt3,fstt4,fstt5,fstt6,fstt7,fstt8,fstt9,fstt10,fstt11,fstt12,amt1,amt2,amt3,amt4,amt5,amt6,amt7,amt8,amt9,amt10,amt11,amt12;
    private ListView list_view;

    Admin_Database AD;
    private String s_ID = null;
    private String sname = null;
    String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12;
    ImageView img17;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fees);

        Intent i = getIntent();
        s_ID = i.getStringExtra("Studentid");

        img17 = findViewById(R.id.img17);

        fstt1 = findViewById(R.id.fstt1);
        fstt2 = findViewById(R.id.fstt2);
        fstt3 = findViewById(R.id.fstt3);
        fstt4 = findViewById(R.id.fstt4);
        fstt5 = findViewById(R.id.fstt5);
        fstt6 = findViewById(R.id.fstt6);
        fstt7 = findViewById(R.id.fstt7);
        fstt8 = findViewById(R.id.fstt8);
        fstt9 = findViewById(R.id.fstt9);
        fstt10 = findViewById(R.id.fstt10);
        fstt11 = findViewById(R.id.fstt11);
        fstt12 = findViewById(R.id.fstt12);

        amt1 = findViewById(R.id.amt1);
        amt2 = findViewById(R.id.amt2);
        amt3 = findViewById(R.id.amt3);
        amt4 = findViewById(R.id.amt4);
        amt5 = findViewById(R.id.amt5);
        amt6 = findViewById(R.id.amt6);
        amt7 = findViewById(R.id.amt7);
        amt8 = findViewById(R.id.amt8);
        amt9 = findViewById(R.id.amt9);
        amt10 = findViewById(R.id.amt10);
        amt11 = findViewById(R.id.amt11);
        amt12 = findViewById(R.id.amt12);


        AD = new Admin_Database(this);

        Cursor c = AD.getFees(s_ID);
        ArrayList<String> list = new ArrayList<>();
        if (c.getCount() == 0) {
            Toast.makeText(FeesDetails.this, "Not Updated Yet", Toast.LENGTH_LONG).show();
        } else {

            while (c.moveToNext()) {

                list.add(c.getString(1));
                list.add(c.getString(2));
                list.add(c.getString(3));
                list.add(c.getString(4));
                list.add(c.getString(5));
                list.add(c.getString(6));
                list.add(c.getString(7));
                list.add(c.getString(8));
                list.add(c.getString(9));
                list.add(c.getString(10));
                list.add(c.getString(11));
                list.add(c.getString(12));


            }
            st1 = list.get(0);

            fstt1.setText(st1);
            //0xFF80FF80
            if (st1.equalsIgnoreCase("Paid")) {
                amt1.setText("4000");
                fstt1.setBackgroundColor(0xFF80FF80);
            } else {
                amt1.setText("0.00");
                fstt1.setBackgroundColor(0xFFFF8080);
                fstt1.setTextColor(0xFFFFFFFF);
            }


            st2 = list.get(1);
            fstt2.setText(st2);

            if (st2.equalsIgnoreCase("Paid")) {
                amt2.setText("4000");
                fstt2.setBackgroundColor(0xFF80FF80);
            } else {
                amt2.setText("0.00");
                fstt2.setBackgroundColor(0xFFFF8080);
                fstt2.setTextColor(0xFFFFFFFF);
            }


            st3 = list.get(2);
            fstt3.setText(st3);

            if (st3.equalsIgnoreCase("Paid")) {
                amt3.setText("4000");
                fstt3.setBackgroundColor(0xFF80FF80);
            } else {
                amt3.setText("0.00");
                fstt3.setBackgroundColor(0xFFFF8080);
                fstt3.setTextColor(0xFFFFFFFF);
            }


            st4 = list.get(3);
            fstt4.setText(st4);
            if (st4.equalsIgnoreCase("Paid")) {
                amt4.setText("4000");
                fstt4.setBackgroundColor(0xFF80FF80);
            } else {
                amt4.setText("0.00");
                fstt4.setBackgroundColor(0xFFFF8080);
                fstt4.setTextColor(0xFFFFFFFF);
            }

            st5 = list.get(4);
            fstt5.setText(st5);

            if (st5.equalsIgnoreCase("Paid")) {
                amt5.setText("4000");
                fstt5.setBackgroundColor(0xFF80FF80);
            } else {
                amt5.setText("0.00");
                fstt5.setBackgroundColor(0xFFFF8080);
                fstt5.setTextColor(0xFFFFFFFF);
            }

            st6 = list.get(5);
            fstt6.setText(st6);

            if (st6.equalsIgnoreCase("Paid")) {
                amt6.setText("4000");
                fstt6.setBackgroundColor(0xFF80FF80);
            } else {
                amt6.setText("0.00");
                fstt6.setBackgroundColor(0xFFFF8080);
                fstt6.setTextColor(0xFFFFFFFF);
            }

            st7 = list.get(6);
            fstt7.setText(st7);

            if (st7.equalsIgnoreCase("Paid")) {
                amt7.setText("4000");
                fstt7.setBackgroundColor(0xFF80FF80);
            } else {
                amt7.setText("0.00");
                fstt7.setBackgroundColor(0xFFFF8080);
                fstt7.setTextColor(0xFFFFFFFF);
            }

            st8 = list.get(7);
            fstt8.setText(st8);

            if (st8.equalsIgnoreCase("Paid")) {
                amt8.setText("4000");
                fstt8.setBackgroundColor(0xFF80FF80);
            } else {
                amt8.setText("0.00");
                fstt8.setBackgroundColor(0xFFFF8080);
                fstt8.setTextColor(0xFFFFFFFF);
            }

            st9 = list.get(8);
            fstt9.setText(st9);

            if (st9.equalsIgnoreCase("Paid")) {
                amt9.setText("4000");
                fstt9.setBackgroundColor(0xFF80FF80);
            } else {
                amt9.setText("0.00");
                fstt9.setBackgroundColor(0xFFFF8080);
                fstt9.setTextColor(0xFFFFFFFF);
            }

            st10 = list.get(9);
            fstt10.setText(st10);

            if (st10.equalsIgnoreCase("Paid")) {
                amt10.setText("4000");
                fstt10.setBackgroundColor(0xFF80FF80);
            } else {
                amt10.setText("0.00");
                fstt10.setBackgroundColor(0xFFFF8080);
                fstt10.setTextColor(0xFFFFFFFF);
            }

            st11 = list.get(10);
            fstt11.setText(st11);

            if (st11.equalsIgnoreCase("Paid")) {
                amt11.setText("4000");
                fstt11.setBackgroundColor(0xFF80FF80);
            } else {
                amt11.setText("0.00");
                fstt11.setBackgroundColor(0xFFFF8080);
                fstt11.setTextColor(0xFFFFFFFF);
            }

            st12 = list.get(11);
            fstt12.setText(st12);

            if (st12.equalsIgnoreCase("Paid")) {
                amt12.setText("4000");
                fstt12.setBackgroundColor(0xFF80FF80);
            } else {
                amt12.setText("0.00");
                fstt12.setBackgroundColor(0xFFFF8080);
                fstt12.setTextColor(0xFFFFFFFF);
            }
        }

        img17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeesDetails.this, Parent_Portal.class);
                startActivity(i);
            }
        });
    }

}

