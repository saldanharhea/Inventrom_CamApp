package com.example.rheasaldanha.photostats;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import java.io.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rheasaldanha on 28/08/17.
 */

public class action extends Fragment {

    ImageView imageView;
    Bitmap bitmap;
    Button btn2;
    public String pass;


private File imageFile;
    private AlertDialog dialog;
    @Nullable




 public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.action, container, false);

        Button btn = (Button) v.findViewById(R.id.button);
        imageView = (ImageView) v.findViewById(R.id.ImageView);
         btn2 = (Button) v.findViewById(R.id.button2);
       // but1 = (Button) v.findViewById(R.id.button3);







        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);



                startActivityForResult(intent, 0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {

                Intent change = new Intent(action.this.getActivity(),sec.class);

                startActivityForResult(change,0);


            }
        });

        return v;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);

        startSave();

        //[displaying button]
        btn2.setVisibility(View.VISIBLE);




    }

    public void startSave()
    {
        FileOutputStream  fileOutputStream=null;
        File file=getDisc();
        if(!file.exists() && !file.mkdirs()){
            //Toast.makeText(this,"cant save",Toast.LENGTH_LONG).show();
            return;
        }


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmsshhmmss");
        String date=simpleDateFormat.format(new Date());
        String name="Img"+date+".jpeg";
        Log.w("hahaha",name);


        pass= name;


        String file_name= file.getAbsolutePath()+"/"+name;
        File new_file= new File(file_name);
        try {
            fileOutputStream = new FileOutputStream(new_file);
            //Bitmap bitma=viewToBitmap(imageView,imageView.getWidth(),imageView.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.flush();;
            fileOutputStream.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
            refreshGallery(new_file);

    }

    public void refreshGallery(File file)
    {
        Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        getActivity().sendBroadcast(intent);

    }



    public File getDisc(){

     File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
     return new File(file,"PhotoStat");

 }




}