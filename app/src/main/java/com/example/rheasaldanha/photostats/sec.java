package com.example.rheasaldanha.photostats;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class sec extends AppCompatActivity {

    String name,address,age,gender,Message,mes;
    EditText e1,e2,e3;
    RadioGroup rg;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Log.w("gf","hi");
        setContentView(R.layout.form);













        b1=(Button)findViewById(R.id.bt3);

        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {


                e1= (EditText)findViewById(R.id.input_name);
                name = e1.getText().toString();

                e2= (EditText)findViewById(R.id.input_address);
                address = e2.getText().toString();


                e3= (EditText)findViewById(R.id.input_age);
                age = e3.getText().toString();



                rg= (RadioGroup)findViewById(R.id.rg1);
                gender = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();


                //string that contains alldetails [Rhea]
                Message ="Name : "+name+"\n Age : "+age+"\n Address : "+address+"\n Gender :"+gender ;
                Log.w("ds",Message);



                try {

                    // savig file as name.txt[rhea]
                    String file_name=name+".txt";

                    FileOutputStream fileout=openFileOutput(file_name, MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write(Message);
                    outputWriter.close();

                    // path at which file is stored[rhea]

                    String path = getFilesDir().getAbsolutePath();
                    String out_msg ="File "+file_name+" saved successfully at "+path;

                    Toast.makeText(getBaseContext(), out_msg,
                            Toast.LENGTH_LONG).show();


                    Intent change = new Intent(sec.this,third.class);
                    change.putExtra("message",mes);
                    startActivityForResult(change,0);
                    //Log.w("ds",path);





                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        });

    }




}
