package com.example.rheasaldanha.photostats;

/**
 * Created by rheasaldanha on 29/08/17.
 */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class triangle
{

    // x, y, z
    private float vertices[] =
            {
                    -1.0f, 0.0f, 0.0f,  // vertices[0], bottom left
                    1.0f, 0.0f, 0.0f,   // vertices[1], bottom right
                    1.0f, 1.0f, 0.0f,   // vertices[2], middle top
            };

    // Just some random values *g*
    private float colors[] =
            {
                    0.0f, 1.0f, 0.0f, 1.0f,
                    1.0f, 0.0f, 0.0f, 1.0f,
                    1.0f, 0.0f, 0.0f, 1.0f,

            };

    // connect vertices[0] with vertices[1] and vertices[1] with vertices[2]
    // and vertices[2] with vertices[1] :-) */
    private short[] indices =
            {
                    0, 1, 2, 1
            };
    private FloatBuffer vertexBuffer;
    private FloatBuffer mColorBuffer;
    private ShortBuffer indexBuffer;

    public triangle()
    {
        // Multiply with 4 because a float is 4 bytes
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        // Multiply with 4 because a float is 4 bytes
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mColorBuffer = byteBuf.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        // Multiply with 2 because a short is 2 bytes
        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        indexBuffer = ibb.asShortBuffer();
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glFrontFace(GL10.GL_CCW);    // Counter-clockwise winding
        gl.glEnable(GL10.GL_CULL_FACE); // Enable face culling
        gl.glCullFace(GL10.GL_BACK);    // What faces to remove with the face culling

        // Enabled the vertices buffer for writing and to be used during rendering:
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        // Specifies the location and data format for rendering:
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);  // Disable the vertices buffer
        gl.glDisable(GL10.GL_CULL_FACE);                // Disable the face culling
    }
}






















