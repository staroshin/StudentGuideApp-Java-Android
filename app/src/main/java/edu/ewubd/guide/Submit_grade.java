package edu.ewubd.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Submit_grade extends AppCompatActivity {
    private Button sub_grade;
    Teacher_Database TD;
    EditText sid,grade1,grade2;
    ImageView img21;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_grade);


        sid = findViewById(R.id.s_sid);
        img21 = findViewById(R.id.img21);



        grade1 = findViewById(R.id.s_grade1);
        grade2 = findViewById(R.id.s_grade2);



        TD = new Teacher_Database(this);

        sub_grade = findViewById(R.id.sub_grade);

        save_data();

        img21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Submit_grade.this, Teacher_Portal.class);
                startActivity(i);
            }
        });




    }
    public void save_data()
    {
        sub_grade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean isInserted = TD.addGrade(sid.getText().toString(),grade1.getText().toString(),grade2.getText().toString());

                if(isInserted == true)
                {
                    Toast.makeText(Submit_grade.this,"Successful",Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(Submit_grade.this, Teacher_Portal.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Submit_grade.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



