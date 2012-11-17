//package com.lll;
//
//import android.app.Activity;
//import android.os.Bundle;
//
//public class LoginDemoActivity extends Activity {
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//    }
//}
package com.lll;

import com.lll.activity.BaseActivity;
import com.lll.activity.LoginActivity;
import com.lll.platform.GeneralPlatform;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class LoginDemoActivity extends Activity implements OnClickListener {

	private TextView view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题栏
		// 取消状态栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		view = (TextView) findViewById(R.id.hello);
		view.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		//登录操作
		GeneralPlatform.getInstance().login(LoginDemoActivity.this);
	}
	
	@Override
	// 当结果返回后判断并执行操作
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if(requestCode == BaseActivity.LOGIN_CODE) { 
			if (resultCode == RESULT_OK) {
				Bundle extras = intent.getExtras();
				if (extras != null) {
					view.setText(extras.getString("username"));
				}
			}
			if (resultCode == RESULT_CANCELED) {
				view.setText("canceled");
			}
		}
	}
}