package edu.ewubd.guide;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Homework extends AppCompatActivity {



    private ListView list_view;
    Teacher_Database TD;

    ImageView img19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.homework);

        list_view = (ListView) findViewById(R.id.listview);
        img19= findViewById(R.id.img19);

        TD = new Teacher_Database(this);
        show_data();

        img19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homework.this, Parent_Portal.class);
                startActivity(i);
            }
        });
    }
        private void show_data()
        {
            Cursor d = TD.get_data();



            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();






            if(d.getCount()==0){
                Toast.makeText(Homework.this,"No Data",Toast.LENGTH_LONG).show();
            }
            else{
                while(d.moveToNext())
                {
                    list.add(d.getString(0)+ "\n"+ d.getString(1));
                    list2.add(d.getString(0));

                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.one_item,R.id.item,list);

                list_view.setAdapter(adapter);



                list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                    {

                    String h_title = list2.get(i);

                        AlertDialog.Builder builder = new AlertDialog.Builder(Homework.this);

                        builder.setMessage(h_title);
                        builder.setTitle("Homework Details");

                        AlertDialog alert = builder.create();
                        alert.show();

                    }
                });




            }


        }

    }

