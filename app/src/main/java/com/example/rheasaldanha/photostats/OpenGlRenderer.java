package com.example.rheasaldanha.photostats;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGlRenderer implements Renderer
{
    // Initialize the triangle:
    triangle triangle = new triangle();

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        gl.glClearColor(1, 1, 0.99f, 0.5f);  // background color (rgba)
        gl.glShadeModel(GL10.GL_SMOOTH);          // Enable Smooth Shading
        gl.glClearDepthf(1.0f);                   // Depth buffer setup
        gl.glEnable(GL10.GL_DEPTH_TEST);          // Enable depth testing
        gl.glDepthFunc(GL10.GL_LEQUAL);           // Type of depth testing
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    public void onDrawFrame(GL10 gl)
    {
        // Clears the screen and depth buffer:
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // Draw triangle
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        triangle.draw(gl);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        // Sets the current view port to the new size:
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);  // Set projection matrix
        gl.glLoadIdentity();                  // Reset projection matrix
        // Calculate the aspect ratio of the window:
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);   // Select modelview matrix
        gl.glLoadIdentity();                  // Reset modelview matrix
    }
}