package com.j2w2.rbarnes.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorPickerFragment extends Fragment implements SeekBar.OnSeekBarChangeListener,OnClickListener {
	
	static int _redInt;
	static int _greenInt;
	static int _blueInt;
	TextView _colorTextView;
	
	private PickerListener listener;
	
	public interface PickerListener{
		public void onColorChange(int red, int green, int blue);
		
		
	}
	// onCreate
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	   }

	   // onActivityCreated
	   @Override
	   public void onActivityCreated(Bundle savedInstanceState) {
	      super.onActivityCreated(savedInstanceState);
	   }
	   
	   // onCreateView
	   @Override
	   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		   LinearLayout view = (LinearLayout)inflater.inflate(R.layout.fragment_picker,container,false);
		   
	        //grab color text view 
	        _colorTextView=(TextView)view.findViewById(R.id.ColorView1);
	        //Detect seek bars and buttons
	        SeekBar redBar = (SeekBar)view.findViewById(R.id.RedBar);
	        SeekBar greenBar = (SeekBar)view.findViewById(R.id.GreenBar);
	        SeekBar blueBar = (SeekBar)view.findViewById(R.id.BlueBar);
	        Button saveButton = (Button)view.findViewById(R.id.SaveButton);
	        Button webButton = (Button)view.findViewById(R.id.WebButton);
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

		 
			
			
			
	      
	      return view;
	   }
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			switch(v.getId()){
		
		
			case R.id.SaveButton:
			
				listener.onColorChange(_redInt, _greenInt, _blueInt);

					
			break;
		case R.id.WebButton:
			Uri uriUrl = Uri.parse("http://cloford.com/resources/colours/500col.htm");
			Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); 
			startActivity(launchBrowser); 
			break;
		
	}
		
	}
		@Override
		public void onAttach(Activity activity){
			super.onAttach(activity);
			try{
				listener = (PickerListener)activity;
			}catch(ClassCastException e){
				throw new ClassCastException(activity.toString() + "did not Implemnt Picker Listener!");
			}
		}{

			}
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			
			
			TextView redBarText =(TextView)getActivity().findViewById(R.id.RedBarText);
			TextView greenBarText=(TextView)getActivity().findViewById(R.id.GreenBarText);
			TextView blueBarText=(TextView)getActivity().findViewById(R.id.BlueBarText);
			
			
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

		
}
