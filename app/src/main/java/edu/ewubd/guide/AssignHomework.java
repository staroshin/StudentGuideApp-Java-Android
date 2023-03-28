package edu.ewubd.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AssignHomework extends AppCompatActivity {
    private Button sub_hw;
    Teacher_Database TD;
    EditText e_title,dl;
    ImageView img11;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assign_hw);


        e_title = findViewById(R.id.e_title);
        img11 = findViewById(R.id.img11);



        dl = findViewById(R.id.e_dl);



     TD = new Teacher_Database(this);

        sub_hw = findViewById(R.id.sub_hw);

        save_data();

        img11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AssignHomework.this, Teacher_Portal.class);
                startActivity(i);
            }
        });




    }
    public void save_data()
    {
        sub_hw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean isInserted = TD.addValue(e_title.getText().toString(),dl.getText().toString());


                if(isInserted == true)
                {
                    Toast.makeText(AssignHomework.this,"Successful",Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(AssignHomework.this, Teacher_Portal.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AssignHomework.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



