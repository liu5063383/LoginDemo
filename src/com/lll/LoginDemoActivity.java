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

import com.lll.activity.LoginActivity;

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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
//import com.lll.android.FileManager.data.UserDataServiceHelper;
//import com.lll.android.FileManager.view.mainview;

public class LoginDemoActivity extends Activity implements OnClickListener {

	private TextView button1;
	private String usernamestr;
	private String passwordstr;
	private ProgressDialog progressdialog;
	private AlertDialog selfdialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// ȡ��������
		// ȡ��״̬��
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		button1 = (TextView) findViewById(R.id.hello);
		button1.setOnClickListener(this);
		// initview();
	}

	private View view;

	public void initview() {
		// ����view�ӵ�ǰactivity��ȡloginactivity
		LayoutInflater inflater = (LayoutInflater) getApplicationContext()
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.login, null);

		final EditText username = (EditText) view
				.findViewById(R.id.txt_username);
		final EditText password = (EditText) view
				.findViewById(R.id.txt_password);
		username.setText("XXXX");
		password.setText("XXXX"); // Ϊ�˲��Է��������������ʼ���������������˺�����
		AlertDialog.Builder ad = new AlertDialog.Builder(LoginDemoActivity.this);
		ad.setView(view);
		ad.setTitle("�˺ŵ�½");
		selfdialog = ad.create();

		selfdialog.setButton("��½", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// ��ȡ�������û�������

				usernamestr = username.getText().toString();
				passwordstr = password.getText().toString();
				progressdialog = ProgressDialog.show(LoginDemoActivity.this,
						"��ȴ�...", "����Ϊ����½...");
				refreshHandler.sleep(100);
				// dialog.cancel();
			}
		});
		selfdialog.setButton2("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				selfdialog.cancel();
			}
		});
		selfdialog.show();
	}

	private RefreshHandler refreshHandler = new RefreshHandler();

	// ������
	class RefreshHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			try {

				// �������ύ���������Ĵ��룬��װ�������ﲻ�ٸ������������Ӻܶ��������
				// String host =UserDataServiceHelper.getHost();
				String host = "";
				String uri = host + "/anndroiduser.do?user=login";

				/**
				 * flag �ǽ������Է������˵����ݰ�װ������ͻ�������������õ���json
				 * 
				 * json���������󣬽��������bundle,�磺
				 * 
				 * Bundle bagent =new Bundle(); bagent.putSerializable("agent",
				 * agent);
				 */

				// Bundle flag = UserDataServiceHelper.login(uri, usernamestr,
				// passwordstr);
				Bundle flag = new Bundle();
				if (flag != null) {
					Toast.makeText(LoginDemoActivity.this, "��½�ɹ�",
							Toast.LENGTH_SHORT).show();
					// Intent intent = new Intent();
					// intent.setClass(EHRActivity.this, FileManager.class);
					// intent.putExtras(flag);
					// LoginDemoActivity.this.finish();
				} else {
					Toast.makeText(LoginDemoActivity.this, "��½ʧ��",
							Toast.LENGTH_SHORT).show();
					view.findViewById(R.id.txt_loginerror).setVisibility(
							View.VISIBLE);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				progressdialog.dismiss();// ���������
			}
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	}

	@Override
	public void onClick(View v) {
		Intent in = new Intent();
		in.setClass(LoginDemoActivity.this, LoginActivity.class);
		startActivityForResult(in, 0);
	}

	@Override
	// ��������غ��жϲ�ִ�в���
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if (requestCode != 0) {
			if (resultCode == RESULT_OK) {
				Bundle extras = intent.getExtras();
				if (extras != null) {
				}
			}
		}
	}
}