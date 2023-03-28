package edu.ewubd.guide;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private Button btnLogin,crt;
    Login_Database DB;
    EditText username, password,c_pass,std_id,std_name,f_name,pphone;
    String type;
    ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);


        btnLogin = findViewById(R.id.btnLogin);
        crt = findViewById(R.id.crt);
        img5 = findViewById(R.id.img5);

        f_name = findViewById(R.id.e_f_name);

        username = findViewById(R.id.e_name);

        password = findViewById(R.id.e_pw);
        c_pass = findViewById(R.id.e_cpw);
        pphone = findViewById(R.id.e_pphone);

        type = "parent";
        std_id = findViewById(R.id.e_std_id);
        std_name = findViewById(R.id.e_std_name);


        DB = new Login_Database(this);




        save_data();

        img5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, Type.class);
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
                String sid = std_id.getText().toString();
                String fname = f_name.getText().toString();
                String phn = pphone.getText().toString();
                String sname = std_name.getText().toString();
                String pw = password.getText().toString();
                 String cpw = c_pass.getText().toString();



                if (uname.equals("") || pw.equals("") || sid.equals("") || fname.equals("")|| phn.equals("")|| sname.equals(""))
                    Toast.makeText(SignupActivity.this,"Fill up all fields",Toast.LENGTH_LONG).show();
                else {
                if (pw.equalsIgnoreCase(cpw)){
                    boolean isInserted = DB.addData(username.getText().toString(), password.getText().toString(), type, std_id.getText().toString(), std_name.getText().toString(), f_name.getText().toString(),pphone.getText().toString());

                if (isInserted == true) {
                    Toast.makeText(SignupActivity.this, "Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
            else
                {
                    Toast.makeText(SignupActivity.this, "Password Unmatched", Toast.LENGTH_LONG).show();
                }
                }

            }

        });
    }
}




