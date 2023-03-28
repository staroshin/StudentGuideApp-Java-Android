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

public class UpdateFees extends AppCompatActivity {



   EditText s_sid;
   RadioButton paid,pending,paid2,pending2,paid3,pending3,paid4,pending4,paid5,pending5,paid6,pending6,paid7,pending7,paid8,pending8,paid9,pending9,paid10,pending10,paid11,pending11,paid12,pending12;
   Teacher_Database TD;

    Button sub_fees;
    Admin_Database AD;

    ImageView img9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.update_fees);

        s_sid = findViewById(R.id.s_sid2);
        sub_fees = findViewById(R.id.sub_fees);
        TD = new Teacher_Database(this);
        AD = new Admin_Database(this);

        img9 = findViewById(R.id.img9);

        paid = findViewById(R.id.paid);
        pending = findViewById(R.id.pending);

        paid2 = findViewById(R.id.paid2);
        pending2 = findViewById(R.id.pending2);

        paid3 = findViewById(R.id.paid3);
        pending3 = findViewById(R.id.pending3);

        paid4 = findViewById(R.id.paid4);
        pending4 = findViewById(R.id.pending4);

        paid5 = findViewById(R.id.paid5);
        pending5 = findViewById(R.id.pending5);

        paid6 = findViewById(R.id.paid6);
        pending6 = findViewById(R.id.pending6);

        paid7 = findViewById(R.id.paid7);
        pending7 = findViewById(R.id.pending7);

        paid8 = findViewById(R.id.paid8);
        pending8 = findViewById(R.id.pending8);

        paid9 = findViewById(R.id.paid9);
        pending9 = findViewById(R.id.pending9);

        paid10 = findViewById(R.id.paid10);
        pending10 = findViewById(R.id.pending10);

        paid11 = findViewById(R.id.paid11);
        pending11 = findViewById(R.id.pending12);

        paid12 = findViewById(R.id.paid12);
        pending12 = findViewById(R.id.pending12);









     save_data();

        img9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateFees.this, Admin.class);
                startActivity(i);
            }
        });

    }
    public void save_data()
    {
        sub_fees.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String stt= null ,stt2=null,stt3=null,stt4=null,stt5=null,stt6=null,stt7=null,stt8=null,stt9=null,stt10=null,stt11=null,stt12=null;
                boolean paidTrue = paid.isChecked();
                boolean pendTrue = pending.isChecked();
                if(paidTrue == true)
                {
                    stt = "Paid";
                }
                else{ stt = "Pending";}

                boolean paidTrue2 = paid2.isChecked();
                boolean pendTrue2 = pending2.isChecked();
                if(paidTrue2 == true)
                {
                    stt2 = "Paid";
                }
                else{ stt2 = "Pending";}

                boolean paidTrue3 = paid3.isChecked();
                boolean pendTrue3 = pending3.isChecked();
                if(paidTrue3 == true)
                {
                    stt3 = "Paid";
                }
                else{ stt3 = "Pending";}

                boolean paidTrue4 = paid4.isChecked();
                boolean pendTrue4 = pending4.isChecked();
                if(paidTrue4 == true)
                {
                    stt4 = "Paid";
                }
                else{ stt4 = "Pending";}

                boolean paidTrue5 = paid5.isChecked();
                boolean pendTrue5 = pending5.isChecked();
                if(paidTrue5 == true)
                {
                    stt5 = "Paid";
                }
                else{ stt5 = "Pending";}

                boolean paidTrue6 = paid6.isChecked();
                boolean pendTrue6 = pending6.isChecked();
                if(paidTrue6 == true)
                {
                    stt6 = "Paid";
                }
                else{ stt6 = "Pending";}

                boolean paidTrue7 = paid7.isChecked();
                boolean pendTrue7 = pending7.isChecked();
                if(paidTrue7 == true)
                {
                    stt7 = "Paid";
                }
                else{ stt7 = "Pending";}

                boolean paidTrue8 = paid8.isChecked();
                boolean pendTrue8 = pending8.isChecked();
                if(paidTrue8 == true)
                {
                    stt8 = "Paid";
                }
                else{ stt8 = "Pending";}

                boolean paidTrue9 = paid9.isChecked();
                boolean pendTrue9 = pending9.isChecked();
                if(paidTrue9 == true)
                {
                    stt9 = "Paid";
                }
                else{ stt9 = "Pending";}

                boolean paidTrue10 = paid10.isChecked();
                boolean pendTrue10 = pending10.isChecked();
                if(paidTrue10 == true)
                {
                    stt10 = "Paid";
                }
                else{ stt10 = "Pending";}

                boolean paidTrue11 = paid11.isChecked();
                boolean pendTrue11 = pending11.isChecked();
                if(paidTrue11 == true)
                {
                    stt11 = "Paid";
                }
                else{ stt11 = "Pending";}

                boolean paidTrue12 = paid12.isChecked();
                boolean pendTrue12 = pending12.isChecked();
                if(paidTrue12 == true)
                {
                    stt12 = "Paid";
                }
                else{ stt12 = "Pending";}


                    if(s_sid.getText().toString().equals(""))
                    {
                        Toast.makeText(UpdateFees.this, "Insert ID", Toast.LENGTH_LONG).show();
                    }
                    else {
                        AD.addFees(s_sid.getText().toString(), stt, stt2, stt3, stt4, stt5, stt6, stt7, stt8, stt9, stt10, stt11, stt12);
                        Toast.makeText(UpdateFees.this, "Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UpdateFees.this, Admin.class);
                        startActivity(intent);
                    }
                }



        });
    }


}

