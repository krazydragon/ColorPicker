/*
 * project	ColorPicker
 * 
 * package	com.j2w2.rbarnes.colorpicker
 * 
 * @author	Ronaldo Barnes
 * 
 * date		May 2, 2013
 */
package com.j2w2.rbarnes.colorpicker;

import com.j2w2.rbarnes.colorpicker.ColorPickerFragment.PickerListener;
import com.rbarnes.other.WebInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class ColorPickerActivity extends FragmentActivity implements PickerListener{
	
	
	
	
	
	Intent _mainIntent;
	TextView _colorTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //grab color text view 
        _colorTextView=(TextView)findViewById(R.id.ColorView1);
        
        _mainIntent = getIntent();
        String favColor = _mainIntent.getStringExtra("fav_color");
        
        
        
        

    	
    	if(WebInterface.getConnectionStatus(this)){
    		_colorTextView.setText(favColor +  " " + this.getString(R.string.fav_color_conn_text));
    		
    	}else{
    		_colorTextView.setText(favColor + " " + this.getString(R.string.fav_color_not_conn_text));
    		
    	}
    	
		
        
        
        
    }
    
    
	
    


	@Override
	public void onColorChange(String hexValue) {
		_mainIntent.putExtra("hexValue", hexValue);
		
		 setResult(RESULT_OK, _mainIntent);
		 finish();
		
	}






	}
