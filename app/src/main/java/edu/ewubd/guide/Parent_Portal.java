package edu.ewubd.guide;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Parent_Portal extends AppCompatActivity {

    TextView textView,textView2;
    Login_Database DB;
Button btn_hw,btn_grade,get_fees,get_pnotice;
    private String existingKey = null;
    private String type = null;
    ImageView img16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent);
        textView = findViewById(R.id.name1);
        textView2 = findViewById(R.id.name2);
        get_pnotice = findViewById(R.id.get_pnotice);
        img16 = findViewById(R.id.img16);
        Intent i = getIntent();

        existingKey = i.getStringExtra("EventKey");

        DB = new Login_Database(this);

        textView2.setText(existingKey);
        btn_hw = findViewById(R.id.btn_hw);
        btn_grade = findViewById(R.id.btn_grade);
        get_fees = findViewById(R.id.get_fees);

        Cursor c = DB.ViewStudentID(existingKey);
        ArrayList<String> list = new ArrayList<>();
      //  StringBuffer buff = new StringBuffer();


        while (c.moveToNext()) {

            //buff.append(c.getString(3));


            list.add(c.getString(3));
            list.add(c.getString(4));

        }


        btn_hw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Parent_Portal.this, Homework.class);
                startActivity(i);


            }
        });
        btn_grade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Parent_Portal.this, GradeReport.class);
                String ssid = list.get(0);
                String sname = list.get(1);

                i.putExtra("SID", ssid);
                i.putExtra("StudentName", sname);

                startActivity(i);


            }
        });
        get_fees.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Parent_Portal.this, FeesDetails.class);
                String ttt = list.get(0);

                i.putExtra("Studentid", ttt);

                startActivity(i);


            }
        });
        get_pnotice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Parent_Portal.this, NoticeDetailsParent.class);


                startActivity(i);


            }
        });

        img16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Parent_Portal.this, MainActivity.class);
                startActivity(i);
            }
        });


    }

}