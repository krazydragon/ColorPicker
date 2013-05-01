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
import com.rbarnes.other.WebInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorPickerActivity extends FragmentActivity implements PickerListener{
	
	
	
	
	
	Intent _mainIntent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //grab color text view 
        TextView colorTextView=(TextView)findViewById(R.id.ColorView1);
        
        _mainIntent = getIntent();
        String favColor = _mainIntent.getStringExtra("fav_color");
        
        
        
        

    	
    	if(WebInterface.getConnectionStatus(this)){
    		colorTextView.setText(favColor +  " " + this.getString(R.string.fav_color_conn_text));
    		
    	}else{
    		colorTextView.setText(favColor + " " + this.getString(R.string.fav_color_not_conn_text));
    		
    	}
    	
		
        
        
        
    }
    
    
	
    


	@Override
	public void onColorChange(int red, int green, int blue) {
		
		_mainIntent.putExtra("redInfo", red);
		_mainIntent.putExtra("greenInfo",green);
		_mainIntent.putExtra("blueInfo",blue);
		 setResult(RESULT_OK, _mainIntent);
		 finish();
		
	}}
