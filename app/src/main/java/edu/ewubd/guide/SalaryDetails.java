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

public class SalaryDetails extends AppCompatActivity {


    TextView fstt1,fstt2,fstt3,fstt4,fstt5,fstt6,fstt7,fstt8,fstt9,fstt10,fstt11,fstt12,amt1,amt2,amt3,amt4,amt5,amt6,amt7,amt8,amt9,amt10,amt11,amt12;
    private ListView list_view;

    Admin_Database AD;
    private String t = null;

    String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12;

    ImageView img13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.salary);

        Intent i = getIntent();

        t = i.getStringExtra("TeacherID");

        img13 = findViewById(R.id.img13);

        AD = new Admin_Database(this);

        fstt1 = findViewById(R.id.s_stt1);
        fstt2 = findViewById(R.id.s_stt2);
        fstt3 = findViewById(R.id.s_stt3);
        fstt4 = findViewById(R.id.s_stt4);
        fstt5 = findViewById(R.id.s_stt5);
        fstt6 = findViewById(R.id.s_stt6);
        fstt7 = findViewById(R.id.s_stt7);
        fstt8 = findViewById(R.id.s_stt8);
        fstt9 = findViewById(R.id.s_stt9);
        fstt10 = findViewById(R.id.s_stt10);
        fstt11 = findViewById(R.id.s_stt11);
        fstt12 = findViewById(R.id.s_stt12);

        amt1 = findViewById(R.id.bln1);
        amt2 = findViewById(R.id.bln2);
        amt3 = findViewById(R.id.bln3);
        amt4 = findViewById(R.id.bln4);
        amt5 = findViewById(R.id.bln5);
        amt6 = findViewById(R.id.bln6);
        amt7 = findViewById(R.id.bln7);
        amt8 = findViewById(R.id.bln8);
        amt9 = findViewById(R.id.bln9);
        amt10 = findViewById(R.id.bln10);
        amt11 = findViewById(R.id.bln11);
        amt12 = findViewById(R.id.bln12);

        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SalaryDetails.this, Teacher_Portal.class);
                startActivity(i);
            }
        });


        Cursor c = AD.getSalary(t);

        ArrayList<String> list = new ArrayList<>();

        if (c.getCount() == 0) {
            Toast.makeText(SalaryDetails.this, "No Data", Toast.LENGTH_LONG).show();
        } else
        {
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


        //0xFF80FF80

        if (st1.equalsIgnoreCase("Paid")) {
            amt1.setText("4000");
            fstt1.setBackgroundColor(0xFF80FF80);
            fstt1.setText("Received");
        } else {
            amt1.setText("0.00");
            fstt1.setText("Pending");
            fstt1.setBackgroundColor(0xFFFF8080);
            fstt1.setTextColor(0xFFFFFFFF);
        }


        st2 = list.get(1);


        if (st2.equalsIgnoreCase("Paid")) {
            fstt2.setText("Received");
            amt2.setText("4000");
            fstt2.setBackgroundColor(0xFF80FF80);
        } else {
            amt2.setText("0.00");
            fstt2.setText("Pending");
            fstt2.setBackgroundColor(0xFFFF8080);
            fstt2.setTextColor(0xFFFFFFFF);
        }


        st3 = list.get(2);


        if (st3.equalsIgnoreCase("Paid")) {
            amt3.setText("4000");
            fstt3.setBackgroundColor(0xFF80FF80);
            fstt3.setText("Received");
        } else {
            amt3.setText("0.00");
            fstt3.setText("Pending");
            fstt3.setBackgroundColor(0xFFFF8080);
            fstt3.setTextColor(0xFFFFFFFF);
        }


        st4 = list.get(3);

        if (st4.equalsIgnoreCase("Paid")) {
            amt4.setText("4000");
            fstt4.setBackgroundColor(0xFF80FF80);
            fstt4.setText("Received");
        } else {
            amt4.setText("0.00");
            fstt4.setText("Pending");
            fstt4.setBackgroundColor(0xFFFF8080);
            fstt4.setTextColor(0xFFFFFFFF);
        }

        st5 = list.get(4);


        if (st5.equalsIgnoreCase("Paid")) {
            amt5.setText("4000");
            fstt5.setBackgroundColor(0xFF80FF80);
            fstt5.setText("Received");
        } else {
            amt5.setText("0.00");
            fstt5.setText("Pending");
            fstt5.setBackgroundColor(0xFFFF8080);
            fstt5.setTextColor(0xFFFFFFFF);
        }

        st6 = list.get(5);


        if (st6.equalsIgnoreCase("Paid")) {
            amt6.setText("4000");
            fstt6.setBackgroundColor(0xFF80FF80);
            fstt6.setText("Received");
        } else {
            amt6.setText("0.00");
            fstt6.setText("Pending");
            fstt6.setBackgroundColor(0xFFFF8080);
            fstt6.setTextColor(0xFFFFFFFF);
        }

        st7 = list.get(6);


        if (st7.equalsIgnoreCase("Paid")) {
            amt7.setText("4000");
            fstt7.setBackgroundColor(0xFF80FF80);
            fstt7.setText("Received");
        } else {
            amt7.setText("0.00");
            fstt7.setText("Pending");
            fstt7.setBackgroundColor(0xFFFF8080);
            fstt7.setTextColor(0xFFFFFFFF);
        }

        st8 = list.get(7);


        if (st8.equalsIgnoreCase("Paid")) {
            amt8.setText("4000");
            fstt8.setBackgroundColor(0xFF80FF80);
            fstt8.setText("Received");
        } else {
            amt8.setText("0.00");
            fstt8.setText("Pending");
            fstt8.setBackgroundColor(0xFFFF8080);
            fstt8.setTextColor(0xFFFFFFFF);
        }

        st9 = list.get(8);


        if (st9.equalsIgnoreCase("Paid")) {
            amt9.setText("4000");
            fstt9.setBackgroundColor(0xFF80FF80);
            fstt9.setText("Received");
        } else {
            amt9.setText("0.00");
            fstt9.setText("Pending");
            fstt9.setBackgroundColor(0xFFFF8080);
            fstt9.setTextColor(0xFFFFFFFF);
        }

        st10 = list.get(9);


        if (st10.equalsIgnoreCase("Paid")) {
            amt10.setText("4000");
            fstt10.setBackgroundColor(0xFF80FF80);
            fstt10.setText("Received");
        } else {
            amt10.setText("0.00");
            fstt10.setText("Pending");
            fstt10.setBackgroundColor(0xFFFF8080);
            fstt10.setTextColor(0xFFFFFFFF);
        }

        st11 = list.get(10);



        if (st11.equalsIgnoreCase("Paid")) {
            amt11.setText("4000");
            fstt11.setBackgroundColor(0xFF80FF80);
            fstt11.setText("Received");
        } else {
            amt11.setText("0.00");
            fstt11.setText("Pending");
            fstt11.setBackgroundColor(0xFFFF8080);
            fstt11.setTextColor(0xFFFFFFFF);
        }

        st12 = list.get(11);


        if (st12.equalsIgnoreCase("Paid")) {
            amt12.setText("4000");
            fstt12.setBackgroundColor(0xFF80FF80);
            fstt12.setText("Received");
        } else {
            amt12.setText("0.00");
            fstt12.setText("Pending");
            fstt12.setBackgroundColor(0xFFFF8080);
            fstt12.setTextColor(0xFFFFFFFF);
        }
    }
    }

}

