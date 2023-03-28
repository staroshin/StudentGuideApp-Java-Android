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

public class GradeReport extends AppCompatActivity {


TextView get_sid,get_grade,get_name,get_fgrade;

    Teacher_Database TD;
    private String ssid = null;
    private String sname = null;


    ImageView img18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.grade_report);
        Intent i = getIntent();
        ssid = i.getStringExtra("SID");
        sname = i.getStringExtra("StudentName");
        get_sid = findViewById(R.id.get_sid);
        get_name = findViewById(R.id.get_name);
        get_grade = findViewById(R.id.get_grade);
        img18= findViewById(R.id.img18);
        get_fgrade = findViewById(R.id.get_fgrade);
        get_name.setText(sname);
        get_sid.setText(ssid);

        TD = new Teacher_Database(this);
        Cursor c = TD.getGrade(ssid);



        ArrayList<String> list = new ArrayList<>();

        if (c.getCount() == 0) {
            Toast.makeText(GradeReport.this, "Not Updated Yet", Toast.LENGTH_LONG).show();
        } else {
            while (c.moveToNext()) {


                list.add(c.getString(1));
                list.add(c.getString(2));
            }

            String hgrade = list.get(0);
            get_grade.setText(hgrade);
            String fgrade = list.get(1);
            get_fgrade.setText(fgrade);
        }

        img18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GradeReport.this, Parent_Portal.class);
                startActivity(i);
            }
        });


    }


}

