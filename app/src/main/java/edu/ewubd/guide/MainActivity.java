package edu.ewubd.guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Login_Database DB;
    Button login, signup;
    EditText uname, pw;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText) findViewById(R.id.e_name);
        pw = (EditText) findViewById(R.id.e_pw);

        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignup);
        img = findViewById(R.id.img);
        DB = new Login_Database(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(MainActivity.this, Type.class);
                startActivity(is);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = uname.getText().toString();
                String pass = pw.getText().toString();


                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Fill up all fields", Toast.LENGTH_SHORT).show();
                else if (user.equals("admin") || pass.equals("admin")) {
                    Intent a = new Intent(MainActivity.this, Admin.class);

                    startActivity(a);
                    Toast.makeText(MainActivity.this, "Admin", Toast.LENGTH_SHORT).show();
                }
                    else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();


                        Cursor cur = DB.ViewData(user);
                        StringBuffer buff = new StringBuffer();
                        String type;
                        while (cur.moveToNext()) {

                            buff.append(cur.getString(2));
                            type = buff.toString();


                            if (type.equalsIgnoreCase("parent")) {
                                Intent intent1 = new Intent(MainActivity.this, Parent_Portal.class);
                                intent1.putExtra("EventKey", user);


                                startActivity(intent1);
                            } else if (type.equalsIgnoreCase("teacher")) {
                                Intent intent2 = new Intent(MainActivity.this, Teacher_Portal.class);
                                intent2.putExtra("EventKey", user);
                                startActivity(intent2);
                            } else {
                                Toast.makeText(MainActivity.this, "Doesn't Exist", Toast.LENGTH_SHORT).show();

                            }
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "INVALID", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}



