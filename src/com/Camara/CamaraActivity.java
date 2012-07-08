package com.Camara;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CamaraActivity extends Activity {
    /** Called when the activity is first created. */
	private static final int CAMERA_PIC_REQUEST = 1337;
	ImageView imageView ;
	Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.btn);
        imageView = (ImageView) findViewById(R.id.image);
        btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent myIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			        startActivityForResult(myIntent, CAMERA_PIC_REQUEST);  		
			}
        	
        });
       
        		 }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_PIC_REQUEST) {  
        	Bitmap thumbnail = (Bitmap) data.getExtras().get("data"); 
        	imageView.setImageBitmap(thumbnail);
            // do something  
        }  
    }
}