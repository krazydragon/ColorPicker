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



import com.j2w2.rbarnes.colorpicker.ColorMainFragment.FavoriteListener;
import com.j2w2.rbarnes.colorpicker.ColorPickerFragment.PickerListener;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class ColorMainActivity extends FragmentActivity implements FavoriteListener, PickerListener {
	
	LinearLayout _sliderLayout;
	TextView _colorTextView;
	View _view;
	Toast _toast;
	EditText _favText;
	Button _webButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_main);
		_view = (View)findViewById(R.id.MainLayout);
		
		_colorTextView = (TextView)findViewById(R.id.ColorView1);
		_favText = (EditText)findViewById(R.id.color_input_field);
		
		
		//set toast text
		_toast = Toast.makeText(this, "Please enter a color!.", Toast.LENGTH_SHORT);
		
		//Check for screen rotation by checking for user input
		if(_favText.getText().toString().length() > 0){
			this.showPickerFragment();
			
		}
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
		  if(data.getExtras().containsKey("hexValue")){
			  
			  
			  _view.setBackgroundColor(Color.parseColor(data.getStringExtra("hexValue")));
			  
			  _favText.setText("");
			  }
		  }
	}

	@Override
	public void displayToast() {
		// TODO Auto-generated method stub
		_toast.show();
	}

	@Override
	public void showPicker(String favoriteColor) {
		// TODO Auto-generated method stub
		
		final Intent pickerIntent = new Intent(this, ColorPickerActivity.class);
		ColorPickerFragment fragment = (ColorPickerFragment)getSupportFragmentManager().findFragmentById(R.id.pickerFragment);
		
		if ((fragment != null)&& fragment.isInLayout()){
			this.showPickerFragment();
		} else {
			//Save color and launch picker activity
			pickerIntent.putExtra("fav_color", favoriteColor);
			
			
			startActivityForResult(pickerIntent,0);
		}
		
		
	}

	@Override
	public void onColorChange(String hexValue) {
		
		
		
		_view.setBackgroundColor(Color.parseColor(hexValue));
		_colorTextView.setText(this.getString(R.string.pick_text));
		_sliderLayout.setVisibility(View.GONE);
		_favText.setText("");
	}
	
	private void showPickerFragment(){
		_colorTextView.setText(_favText.getText().toString() + " " + this.getString(R.string.fav_color_main_text));
		_sliderLayout.setVisibility(View.VISIBLE);
		_webButton.setVisibility(View.GONE);
	}

	
	@Override
	public void onBackPressed()
	{
		WebView myWebView = (WebView)findViewById(R.id.webview);
	    if(myWebView.canGoBack())
	    	myWebView.goBack();
	    else
	        super.onBackPressed();
	}

}
