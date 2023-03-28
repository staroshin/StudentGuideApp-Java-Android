package edu.ewubd.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Type extends AppCompatActivity {
    private Button t_parent,t_teacher;


    ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type);


        t_parent = findViewById(R.id.t_parent);
        img4 = findViewById(R.id.img4);









        t_teacher = findViewById(R.id.t_teacher);



        img4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Type.this, MainActivity.class);
                startActivity(i);
            }
        });
        t_parent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Type.this, SignupActivity.class);
                startActivity(i);
            }
        });
        t_teacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Type.this, SignupActivity2.class);
                startActivity(i);
            }
        });




    }

}



