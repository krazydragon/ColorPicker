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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("SetJavaScriptEnabled")
public class ColorPickerFragment extends Fragment {
	
	static int _redInt;
	static int _greenInt;
	static int _blueInt;
	TextView _colorTextView;
	Context _context;
	RelativeLayout view;
	
	
	
	
	
	public class JSInterface {Context _con;
		  public JSInterface(Context context) {
			  _con = context;
		  }
		  
		  //capure users choice
		  @JavascriptInterface
		  public void saveColor(String hexValue){
		  Log.i("User Choice",hexValue);
		  
		  listener.onColorChange(hexValue);
		  }
		  
		  
	}
	private PickerListener listener;
	
	public interface PickerListener{
		public void onColorChange(String hexValue);
		
		
		
		
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
		   
		   
		   view = (RelativeLayout)inflater.inflate(R.layout.fragment_picker,container,false);
		   
	        //grab color text view 
	        _colorTextView=(TextView)view.findViewById(R.id.ColorView1);
	        
	        //load webview and set js
	        WebView myWebView = (WebView)view.findViewById(R.id.webview);
	        myWebView.getSettings().setJavaScriptEnabled(true);
	        myWebView.addJavascriptInterface(new JSInterface( getActivity()), "Native");
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
