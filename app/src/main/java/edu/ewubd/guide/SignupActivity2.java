package edu.ewubd.guide;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity2 extends AppCompatActivity {
    private Button btnLogin,crt;
    Login_Database DB;
    EditText username,full_name,password,phone,t_id,r_pw;
    String type;
    ImageView img6;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form2);


        btnLogin = findViewById(R.id.btnLogin);
        crt = findViewById(R.id.crt);
        full_name = findViewById(R.id.e_full_name);
        username = findViewById(R.id.e_name);

        password = findViewById(R.id.e_pw);
        r_pw = findViewById(R.id.e_r_pw);
        phone = findViewById(R.id.e_phone);
        t_id = findViewById(R.id.e_t_id);

        img6 = findViewById(R.id.img6);



        type = "teacher";



        DB = new Login_Database(this);




        save_data();
        img6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity2.this, Type.class);
                startActivity(i);
            }
        });


    }
    public void save_data()
    {
        crt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String tid = t_id.getText().toString();
                String fname = full_name.getText().toString();
                String phn = phone.getText().toString();


                String pw = password.getText().toString();
                String cpw = r_pw.getText().toString();

                if (uname.equals("") || pw.equals("") || tid.equals("") || fname.equals("")|| phn.equals(""))
                    Toast.makeText(SignupActivity2.this,"Fill up all fields",Toast.LENGTH_LONG).show();
                else {
                    if (pw.equalsIgnoreCase(cpw)) {
                        boolean isInserted = DB.addTeacher(username.getText().toString(), password.getText().toString(), type, t_id.getText().toString(), "", full_name.getText().toString(),phone.getText().toString());

                        if (isInserted == true) {
                            Toast.makeText(SignupActivity2.this, "Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignupActivity2.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignupActivity2.this, "Failed", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(SignupActivity2.this, "Password Unmatched", Toast.LENGTH_LONG).show();
                    }
                }

            }

        });
    }
}



