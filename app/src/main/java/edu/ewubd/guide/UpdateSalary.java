package edu.ewubd.guide;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateSalary extends AppCompatActivity {



    EditText t_id;
    RadioButton spaid,spending,spaid2,spending2,spaid3,spending3,spaid4,spending4,spaid5,spending5,spaid6,spending6,spaid7,spending7,spaid8,spending8,spaid9,spending9,spaid10,spending10,spaid11,spending11,spaid12,spending12;

    String sstt,sstt2,sstt3,sstt4,sstt5,sstt6,sstt7,sstt8,sstt9,sstt10,sstt11,sstt12;
    Button sub_salary;
    Admin_Database AD;

    ImageView img8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.update_salary);

        t_id = findViewById(R.id.e_tid);
        sub_salary = findViewById(R.id.sub_salary);

        img8 = findViewById(R.id.img8);

        AD = new Admin_Database(this);

        spaid = findViewById(R.id.spaid);
        spending = findViewById(R.id.spending);

        spaid2 = findViewById(R.id.spaid2);
        spending2 = findViewById(R.id.spending2);

        spaid3 = findViewById(R.id.spaid3);
        spending3 = findViewById(R.id.spending3);

        spaid4 = findViewById(R.id.spaid4);
        spending4 = findViewById(R.id.spending4);

        spaid5 = findViewById(R.id.spaid5);
        spending5 = findViewById(R.id.spending5);

        spaid6 = findViewById(R.id.spaid6);
        spending6 = findViewById(R.id.spending6);

        spaid7 = findViewById(R.id.spaid7);
        spending7 = findViewById(R.id.spending7);

        spaid8 = findViewById(R.id.spaid8);
        spending8 = findViewById(R.id.spending8);

        spaid9 = findViewById(R.id.spaid9);
        spending9 = findViewById(R.id.spending9);

        spaid10 = findViewById(R.id.spaid10);
        spending10 = findViewById(R.id.spending10);

        spaid11 = findViewById(R.id.spaid11);
        spending11 = findViewById(R.id.spending11);

        spaid12 = findViewById(R.id.spaid12);
       spending12 = findViewById(R.id.spending12);









        save_data();

        img8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateSalary.this, Admin.class);
                startActivity(i);
            }
        });

    }
    public void save_data()
    {
        sub_salary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean paidTrue = spaid.isChecked();
                boolean pendTrue = spending.isChecked();
                if(paidTrue == true)
                {
                    sstt = "Paid";
                }
                else{ sstt = "Pending";}

                boolean paidTrue2 = spaid2.isChecked();
                boolean pendTrue2 = spending2.isChecked();
                if(paidTrue2 == true)
                {
                    sstt2 = "Paid";
                }
                else{ sstt2 = "Pending";}

                boolean paidTrue3 = spaid3.isChecked();
                boolean pendTrue3 = spending3.isChecked();
                if(paidTrue3 == true)
                {
                    sstt3 = "Paid";
                }
                else{ sstt3 = "Pending";}

                boolean paidTrue4 = spaid4.isChecked();
                boolean pendTrue4 = spending4.isChecked();
                if(paidTrue4 == true)
                {
                    sstt4 = "Paid";
                }
                else{ sstt4 = "Pending";}

                boolean paidTrue5 = spaid5.isChecked();
                boolean pendTrue5 = spending5.isChecked();
                if(paidTrue5 == true)
                {
                    sstt5 = "Paid";
                }
                else{ sstt5 = "Pending";}

                boolean paidTrue6 = spaid6.isChecked();
                boolean pendTrue6 = spending6.isChecked();
                if(paidTrue6 == true)
                {
                    sstt6 = "Paid";
                }
                else{ sstt6 = "Pending";}

                boolean paidTrue7 = spaid7.isChecked();
                boolean pendTrue7 = spending7.isChecked();
                if(paidTrue7 == true)
                {
                    sstt7 = "Paid";
                }
                else{ sstt7 = "Pending";}

                boolean paidTrue8 = spaid8.isChecked();
                boolean pendTrue8 = spending8.isChecked();
                if(paidTrue8 == true)
                {
                    sstt8 = "Paid";
                }
                else{ sstt8 = "Pending";}

                boolean paidTrue9 = spaid9.isChecked();
                boolean pendTrue9 = spending9.isChecked();
                if(paidTrue9 == true)
                {
                    sstt9 = "Paid";
                }
                else{ sstt9 = "Pending";}

                boolean paidTrue10 = spaid10.isChecked();
                boolean pendTrue10 = spending10.isChecked();
                if(paidTrue10 == true)
                {
                    sstt10 = "Paid";
                }
                else{ sstt10 = "Pending";}

                boolean paidTrue11 = spaid11.isChecked();
                boolean pendTrue11 = spending11.isChecked();
                if(paidTrue11 == true)
                {
                    sstt11 = "Paid";
                }
                else{ sstt11 = "Pending";}

                boolean paidTrue12 = spaid12.isChecked();
                boolean pendTrue12 = spending12.isChecked();
                if(paidTrue12 == true)
                {
                   sstt12 = "Paid";
                }
                else{ sstt12 = "Pending";}


                if(t_id.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(UpdateSalary.this,"Insert ID",Toast.LENGTH_LONG).show();
                }
                else {
                    AD.insertSalary(t_id.getText().toString(), sstt, sstt2, sstt3, sstt4, sstt5, sstt6, sstt7, sstt8, sstt9, sstt10, sstt11, sstt12);


                    Toast.makeText(UpdateSalary.this, "Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UpdateSalary.this, Admin.class);
                    startActivity(intent);
                }

            }
        });
    }


}
