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



import com.j2w2.rbarnes.colorpicker.ColorMainFragment.FavoriteListener;
import com.j2w2.rbarnes.colorpicker.ColorPickerFragment.PickerListener;

import android.R.color;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class ColorMainActivity extends FragmentActivity implements FavoriteListener, PickerListener {
	
	View _view;
	Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_main);
		_view = (View)findViewById(R.id.MainLayout);
		//set toast text
		toast = Toast.makeText(this, "Please enter a color!.", Toast.LENGTH_SHORT);
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
			  
			  
			  _view.setBackgroundColor(Color.rgb(data.getIntExtra("redInfo", 0), data.getIntExtra("greenInfo", 0), data.getIntExtra("blueInfo", 0)));
			  }
		  }
	}

	@Override
	public void displayToast() {
		// TODO Auto-generated method stub
		toast.show();
	}

	@Override
	public void showPicker(String favoriteColor) {
		// TODO Auto-generated method stub
		
		final Intent pickerIntent = new Intent(this, ColorPickerActivity.class);
		
		//Save color and launch picker activity
		pickerIntent.putExtra("fav_color", favoriteColor);
			
			
		startActivityForResult(pickerIntent,0);
		
	}

	@Override
	public void onColorChange(int red, int green, int blue) {
		// TODO Auto-generated method stub
		_view.setBackgroundColor(Color.rgb(red, green, blue));
	}

}
