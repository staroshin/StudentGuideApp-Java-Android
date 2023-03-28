package edu.ewubd.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubmitNotice extends AppCompatActivity {
    private Button snotice;

    EditText notice;

    Admin_Database AD;
    ImageView img10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_notice);


        notice = findViewById(R.id.e_not);
        img10 = findViewById(R.id.img10);







        AD = new Admin_Database(this);

        snotice = findViewById(R.id.snotice);

        save_data();

        img10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SubmitNotice.this, Admin.class);
                startActivity(i);
            }
        });




    }
    public void save_data()
    {
        snotice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean isInserted = AD.addNotice(notice.getText().toString());


                if(isInserted == true)
                {
                    Toast.makeText(SubmitNotice.this,"Successful",Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(SubmitNotice.this, Teacher_Portal.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SubmitNotice.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



