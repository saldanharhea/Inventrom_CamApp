package com.example.rheasaldanha.photostats;


import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by rheasaldanha on 28/08/17.
 */

public class showlist extends Fragment {

    private ArrayList<File> fileList = new ArrayList<File>();

    LinearLayout view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.showlist, container, false);


        String path = Environment.getExternalStorageDirectory().toString();
        //Log.d("Files", "Path: " + path);














        view= (LinearLayout)root.findViewById(R.id.view);


        File directory = new File(path,"/DCIM/PhotoStat");

        getfile(directory);

        for (int i = 0; i < fileList.size(); i++) {
            TextView textView = new TextView(getContext());
            textView.setText(fileList.get(i).getName());
            textView.setPadding(5, 5, 5, 5);

            System.out.println(fileList.get(i).getName());



            if (fileList.get(i).isDirectory()) {
                textView.setTextColor(Color.parseColor("#FF0000"));
            }
            view.addView(textView);
        }





        /*

        File[] files = directory.listFiles();
        Log.d("Files", "Size: " + files.length);

        String[] arr = new String[100];

        for (int i = 0; i < files.length; i++) {
            Log.d("Files", "FileName:" + files[i].getName());
            arr[i] = files[i].getName();


        }
        TextView img = (TextView) root.findViewById(R.id.img_name);
        //img.setText("FileName:" + arr+"hiuuiuiuiu");
        img.setText("hello " + arr.length);

        StringBuilder builder = new StringBuilder();

        for (String s : arr) {
            builder.append(s).append(" ");
            img.setText(builder.toString());}

        */


            return root;

        }




    public ArrayList<File> getfile(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    fileList.add(listFile[i]);
                    getfile(listFile[i]);

                } else {
                    if (listFile[i].getName().endsWith(".png")
                            || listFile[i].getName().endsWith(".jpg")
                            || listFile[i].getName().endsWith(".jpeg")
                            || listFile[i].getName().endsWith(".gif"))

                    {
                        fileList.add(listFile[i]);
                    }
                }

            }
        }
        return fileList;
    }




    }


