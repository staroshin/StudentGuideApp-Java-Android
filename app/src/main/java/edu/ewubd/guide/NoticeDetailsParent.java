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

public class NoticeDetailsParent extends AppCompatActivity {



    private ListView nlist_view;
    Admin_Database AD;
    ImageView img23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.notice);

        nlist_view = (ListView) findViewById(R.id.n_listview);
        img23 = findViewById(R.id.img14);

        AD = new Admin_Database(this);
        show_data();

        img23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NoticeDetailsParent.this, Parent_Portal.class);
                startActivity(i);
            }
        });
    }
    private void show_data()
    {
        Cursor d = AD.get_data();



        ArrayList<String> list = new ArrayList<>();






        if(d.getCount()==0){
            Toast.makeText(NoticeDetailsParent.this,"Not Updated Yet",Toast.LENGTH_LONG).show();
        }
        else{
            while(d.moveToNext())
            {
                list.add(d.getString(0));


            }


            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.one_item,R.id.item,list);

            nlist_view.setAdapter(adapter);



            nlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {


                    String n_title = list.get(i);

                    AlertDialog.Builder builder = new AlertDialog.Builder(NoticeDetailsParent.this);

                    builder.setMessage(n_title);
                    builder.setTitle("Notice Details");

                    AlertDialog alert = builder.create();
                    alert.show();

                }
            });




        }


    }

}

