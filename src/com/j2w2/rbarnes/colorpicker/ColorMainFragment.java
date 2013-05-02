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

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ColorMainFragment extends Fragment{
	
	
	
private FavoriteListener listener;
	
	public interface FavoriteListener{
		public void displayToast();
		public void showPicker(String favoriteColor);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		
		RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.fragment_color_main, container, false);
		
		
		//Detect Button
		Button pickButton = (Button) view.findViewById(R.id.PickButton);
		
		
		pickButton.setOnClickListener(new Button.OnClickListener() {  
		@Override
		public void onClick(View v) {
			//Grab users favorite color
			EditText colorField   = (EditText)getActivity().findViewById(R.id.color_input_field);
			String colorText = colorField.getText().toString();
			
			//Detect if anything was inputed
			if(colorText.matches(""))
			{
				
				listener.displayToast();
			}
			else
			{
				//Save color and launch picker activity
				listener.showPicker(colorText);
			}
			
			
		}
        });
		
		
		return view;
	}
	
	

	 

	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener = (FavoriteListener)activity;
		}catch(ClassCastException e){
			throw new ClassCastException(activity.toString() + "did not Implemnt Favorite Listener!");
		}
	}
	
	

} 
