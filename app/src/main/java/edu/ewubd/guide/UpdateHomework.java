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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateHomework extends AppCompatActivity {



    private ListView list_view;
    Teacher_Database TD;

    ImageView img25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.up_homework);

        img25 = findViewById(R.id.img25);

        list_view = (ListView) findViewById(R.id.listview);




        TD = new Teacher_Database(this);
        show_data();
        img25.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateHomework.this, Teacher_Portal.class);
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
            Toast.makeText(UpdateHomework.this,"No Data",Toast.LENGTH_LONG).show();
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

                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdateHomework.this);

                    builder.setMessage("Do you want to delete this homework?");
                    builder.setTitle("Delete Homework");
                    builder.setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    String type = list2.get(i);

                                    TD.deleteDataByKey(type);


                                    Intent intent  = new Intent(UpdateHomework.this, Teacher_Portal.class);
                                    startActivity(intent);

                                }
                            })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = builder.create();

                    alert.setTitle("Delete Homework");
                    alert.show();



                }
            });




        }


    }

}

