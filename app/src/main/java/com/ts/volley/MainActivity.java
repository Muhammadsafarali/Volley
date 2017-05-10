package com.ts.volley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String  url = "https://pp.userapi.com/c638828/v638828331/4ddfd/eFMJRXArvwM.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        getImage();
    }

    private void getImage() {
        ImageRequest request = new ImageRequest(url,
                new Response.Listener

                        () {
                    @Override
                    public void onResponse(Object response) {
                        imageView.setImageBitmap((Bitmap)response);
                    }

                }, 0, 0, null, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(R.drawable.img1);
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(request);
    }



}
