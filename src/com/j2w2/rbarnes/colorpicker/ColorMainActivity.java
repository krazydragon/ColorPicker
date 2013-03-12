/*
 * project	ColorPicker
 * 
 * package	com.j2w2.rbarnes.colorpicker
 * 
 * @author	Ronaldo Barnes
 * 
 * date		Mar 12, 2013
 */
package com.j2w2.rbarnes.colorpicker;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class ColorMainActivity extends Activity {
	
	
	Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_main);
		
		final Intent pickerIntent = new Intent(this, ColorPickerActivity.class);
		//Detect Button
		Button pickButton = (Button) findViewById(R.id.PickButton);
		//set toast text
		toast = Toast.makeText(this, "Please enter a color!.", Toast.LENGTH_SHORT);
		
		pickButton.setOnClickListener(new Button.OnClickListener() {  
		@Override
		public void onClick(View v) {
			//Grab users favorite color
			EditText colorField   = (EditText)findViewById(R.id.color_input_field);
			String colorText = colorField.getText().toString();
			
			//Detect if anything was inputed
			if(colorText.matches(""))
			{
				
				toast.show();
			}
			else
			{
				//Save color and launch picker activity
				pickerIntent.putExtra("fav_color", colorText);
				
				
				startActivityForResult(pickerIntent,0);
			}
			
			
		}
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (resultCode == RESULT_OK && requestCode == 0) {
		  super.onActivityResult(requestCode, resultCode, data);
		  if(data.getExtras().containsKey("redInfo")){
			  
			  View view = (View)findViewById(R.id.MainLayout);
			  view.setBackgroundColor(Color.rgb(data.getIntExtra("redInfo", 0), data.getIntExtra("greenInfo", 0), data.getIntExtra("blueInfo", 0)));
			  
			  

			   

			          }

	  }
	}

}
