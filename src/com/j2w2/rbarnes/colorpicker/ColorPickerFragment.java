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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorPickerFragment extends Fragment {
	
	static int _redInt;
	static int _greenInt;
	static int _blueInt;
	TextView _colorTextView;
	LinearLayout view;
	
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
		   view = (LinearLayout)inflater.inflate(R.layout.fragment_picker,container,false);
		   
	        //grab color text view 
	        _colorTextView=(TextView)view.findViewById(R.id.ColorView1);
	        
	        WebView myWebView = (WebView)view.findViewById(R.id.webview);
	        myWebView.getSettings().setJavaScriptEnabled(true);
	        myWebView.loadUrl("file:///android_asset/www/index.html");
	        
		 
			
			
			
	      
	      return view;
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
		
}
