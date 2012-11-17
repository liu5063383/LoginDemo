package com.lll;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//import com.lll.android.FileManager.data.UserDataServiceHelper;
//import com.lll.android.FileManager.view.mainview;

public class EHRActivity extends Activity implements OnClickListener {

	private ImageView button1;
	private String usernamestr;
	private String passwordstr;
	private ProgressDialog progressdialog;
	private AlertDialog selfdialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题栏
		// 取消状态栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login);
		button1 = (ImageView) findViewById(R.id.buttonLogin1);
		button1.setOnClickListener(this);
		// initview();
	}

	private View view;

	public void initview() {
		// 创建view从当前activity获取loginactivity
		LayoutInflater inflater = (LayoutInflater) getApplicationContext()
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.login, null);

		final EditText username = (EditText) view
				.findViewById(R.id.txt_username);
		final EditText password = (EditText) view
				.findViewById(R.id.txt_password);
		username.setText("XXXX");
		password.setText("XXXX"); // 为了测试方便所以在这里初始化弹出框是填上账号密码
		AlertDialog.Builder ad = new AlertDialog.Builder(EHRActivity.this);
		ad.setView(view);
		ad.setTitle("账号登陆");
		selfdialog = ad.create();

		selfdialog.setButton("登陆", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 获取输入框的用户名密码

				usernamestr = username.getText().toString();
				passwordstr = password.getText().toString();
				progressdialog = ProgressDialog.show(EHRActivity.this,
						"请等待...", "正在为您登陆...");
				refreshHandler.sleep(100);
				// dialog.cancel();
			}
		});
		selfdialog.setButton2("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				selfdialog.cancel();
			}
		});
		selfdialog.show();
	}

	private RefreshHandler refreshHandler = new RefreshHandler();

	// 处理器
	class RefreshHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			try {

				// 这里是提交到服务器的代码，封装代码这里不再给出，网上例子很多可以找找
				// String host =UserDataServiceHelper.getHost();
				String host = "";
				String uri = host + "/anndroiduser.do?user=login";

				/**
				 * flag 是接收来自服务器端的数据包装，这里客户与服务器交互用的是json
				 * 
				 * json解析出对象，将对象放入bundle,如：
				 * 
				 * Bundle bagent =new Bundle(); bagent.putSerializable("agent",
				 * agent);
				 */

//				Bundle flag = UserDataServiceHelper.login(uri, usernamestr,
//						passwordstr);
				Bundle flag = new Bundle();
				Thread.sleep(2000);
				if (flag != null) {
					Toast.makeText(EHRActivity.this, "登陆成功！", Toast.LENGTH_SHORT)
							.show();
//					Intent intent = new Intent();
//					intent.setClass(EHRActivity.this, FileManager.class);
//					intent.putExtras(flag);
					EHRActivity.this.finish();
				} else {
					Toast.makeText(EHRActivity.this, "登陆失败！", Toast.LENGTH_SHORT)
							.show();
					view.findViewById(R.id.txt_loginerror).setVisibility(
							View.VISIBLE);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				progressdialog.dismiss();// 解除进度条
			}
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	}

	@Override
	public void onClick(View v) {
		// 创建view从当前activity获取loginactivity
		LayoutInflater inflater = (LayoutInflater) getApplicationContext()
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.login, null);

		final EditText username = (EditText) view
				.findViewById(R.id.txt_username);
		final EditText password = (EditText) view
				.findViewById(R.id.txt_password);
		username.setText("3001");
		password.setText("3001");
		AlertDialog.Builder ad = new AlertDialog.Builder(EHRActivity.this);
		ad.setView(view);
		ad.setTitle("账号登陆");
		selfdialog = ad.create();
		selfdialog.setButton("登陆", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 获取输入框的用户名密码

				usernamestr = username.getText().toString();
				passwordstr = password.getText().toString();

				// 提交的时候弹出一个进度条对话框，当处理完毕关闭
				progressdialog = ProgressDialog.show(EHRActivity.this,
						"请等待...", "正在为您登陆...");
				refreshHandler.sleep(100);
				// dialog.cancel();
			}
		});
		selfdialog.setButton2("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				selfdialog.cancel();
			}
		});
		selfdialog.show();
	}
}