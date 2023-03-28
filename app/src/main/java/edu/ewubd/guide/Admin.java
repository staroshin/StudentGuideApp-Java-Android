package edu.ewubd.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {


    Button up_fees,up_salary,sub_notice;
    private String existingKey = null;
    private String type = null;
    ImageView img7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        img7 = findViewById(R.id.img7);

        up_fees = findViewById(R.id.up_fees);
        up_salary = findViewById(R.id.up_salary);
        sub_notice = findViewById(R.id.sub_notice);

        up_fees.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Admin.this, UpdateFees.class);



                startActivity(i);


            }
        });
        up_salary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Admin.this, UpdateSalary.class);
                startActivity(i);


            }
        });

        sub_notice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Admin.this, SubmitNotice.class);
                startActivity(i);


            }
        });

        img7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}