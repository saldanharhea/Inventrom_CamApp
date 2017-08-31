package com.example.rheasaldanha.photostats;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.opengl.GLSurfaceView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class third extends AppCompatActivity {


GLSurfaceView gls;
    OpenGlRenderer opr;
public Button bt32;
String mes;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //

        //Toast.makeText(getBaseContext(), mes, Toast.LENGTH_LONG).show();



        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // GLSurfaceView view = new GLSurfaceView(this);
       // GLSurfaceView view2 =(GLSurfaceView) findViewById(R.id.view) ;

        setContentView(R.layout.graph);

    gls =(GLSurfaceView) findViewById(R.id.view1);

gls.setEGLConfigChooser(true);
        gls.setRenderer(new OpenGlRenderer());
        reset();
        //gls.setContentView(new OpenGlRenderer());



    }

public void reset()
{
    bt32 =(Button)findViewById(R.id.bt2);
    bt32.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             Intent reset = new Intent(third.this,MainActivity.class);

            startActivity(reset);
        }
    });
}




}

