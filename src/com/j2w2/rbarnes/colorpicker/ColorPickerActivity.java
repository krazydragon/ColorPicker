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

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorPickerActivity extends Activity implements SeekBar.OnSeekBarChangeListener, OnClickListener{
	
	
	
	static int _redInt;
	static int _greenInt;
	static int _blueInt;
	TextView _colorTextView;
	Intent _nameIntent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //grab color text view 
        _colorTextView=(TextView)findViewById(R.id.ColorView1);
        //Detect seek bars and buttons
        SeekBar redBar = (SeekBar)findViewById(R.id.RedBar);
        SeekBar greenBar = (SeekBar)findViewById(R.id.GreenBar);
        SeekBar blueBar = (SeekBar)findViewById(R.id.BlueBar);
        Button saveButton = (Button)findViewById(R.id.SaveButton);
        Button webButton = (Button)findViewById(R.id.WebButton);
        //Get users favorite color and display
        _nameIntent = getIntent();
        String favColor = _nameIntent.getStringExtra("fav_color");
        _colorTextView.setText(favColor + " is your favorite color! You can customize the the background color by using the RGB sliders. To save please press the save button. For color ideas press the idea button. ");
        
        //Set background color
        _redInt = 255;
        _greenInt = 255;
        _blueInt = 255;
        _colorTextView.setBackgroundColor(Color.rgb(_redInt, _greenInt, _blueInt));
        
        //detect user input
        redBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        saveButton.setOnClickListener(this);
        webButton.setOnClickListener(this);
    }
    
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		
		TextView redBarText =(TextView)findViewById(R.id.RedBarText);
		TextView greenBarText=(TextView)findViewById(R.id.GreenBarText);
		TextView blueBarText=(TextView)findViewById(R.id.BlueBarText);
		
		
		switch(seekBar.getId()){
		
		
		case R.id.RedBar:
			redBarText.setText(Integer.toString(progress));
			_redInt = progress;
			break;
			
		case R.id.BlueBar:
			blueBarText.setText(Integer.toString(progress));
			_blueInt = progress;
			break;
			
		case R.id.GreenBar:
			greenBarText.setText(Integer.toString(progress));
			_greenInt = progress;
			break;
		}
		
		_colorTextView.setBackgroundColor(Color.rgb(_redInt, _greenInt, _blueInt));
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		
		case R.id.SaveButton:
			_nameIntent.putExtra("redInfo", _redInt);
			_nameIntent.putExtra("greenInfo",_greenInt);
			_nameIntent.putExtra("blueInfo",_blueInt);
			 setResult(RESULT_OK, _nameIntent);
			 finish();

					
			break;
		case R.id.WebButton:
			Uri uriUrl = Uri.parse("http://cloford.com/resources/colours/500col.htm");
			Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); 
			startActivity(launchBrowser); 
			break;
		
	}

}}
