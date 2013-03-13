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

import com.j2w2.rbarnes.colorpicker.ColorPickerFragment.PickerListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class ColorPickerActivity extends FragmentActivity implements PickerListener{
	
	
	
	
	TextView _colorTextView;
	Intent _nameIntent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //grab color text view 
        _colorTextView=(TextView)findViewById(R.id.ColorView1);
        _nameIntent = getIntent();
        String favColor = _nameIntent.getStringExtra("fav_color");
        _colorTextView.setText(favColor + " is your favorite color! You can customize the the background color by using the RGB sliders. To save please press the save button. For color ideas press the idea button. ");
        
        
        
    }
    
	
	
    


	@Override
	public void onColorChange(int red, int green, int blue) {
		
		
	}}
