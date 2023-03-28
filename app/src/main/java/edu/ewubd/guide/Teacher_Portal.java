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

public class Teacher_Portal extends AppCompatActivity {


    Button btn_hwi,view_hw,sub_grade,v_salary,get_tnotice;
    ImageView img2;
    Login_Database DB;

    private String existingKey = null;
    private String type = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher);

        Intent i = getIntent();

        existingKey = i.getStringExtra("EventKey");

        DB = new Login_Database(this);

        btn_hwi = findViewById(R.id.btn_hwi);
        sub_grade = findViewById(R.id.sub_grade);
        view_hw = findViewById(R.id.view_hw);
        v_salary = findViewById(R.id.v_salary);
        get_tnotice = findViewById(R.id.get_tnotice);
        img2 = findViewById(R.id.img2);

        Cursor c = DB.ViewTeacherID(existingKey);

        ArrayList<String> list = new ArrayList<>();


        while (c.moveToNext())
        {
            list.add(c.getString(3));
        }

        btn_hwi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Teacher_Portal.this, AssignHomework.class);
                startActivity(i);

            }
        });
        sub_grade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Teacher_Portal.this, Submit_grade.class);
                startActivity(i);

            }
        });
        view_hw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Teacher_Portal.this, UpdateHomework.class);
                startActivity(i);

            }
        });


        img2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Teacher_Portal.this, MainActivity.class);
                startActivity(i);
            }
        });

        v_salary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Teacher_Portal.this, SalaryDetails.class);
                String tid = list.get(0);

                i.putExtra("TeacherID", tid);

                startActivity(i);


            }
        });

        get_tnotice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Teacher_Portal.this, NoticeDetails.class);



               startActivity(i);


            }
        });









    }

}