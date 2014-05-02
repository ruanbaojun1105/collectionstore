package example.arrgetest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginView extends Activity {

	// String[] user = { "baojun", "anhua", "shichu", "jianfei", "junlin",
	// "yongsheng", "xuerui","bingbing" };
	// String pass = "123456";
	String username = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.login);
		final Button button1 = (Button) findViewById(R.id.buttonE);
		Button button2 = (Button) findViewById(R.id.buttonF);
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		final EditText editText2 = (EditText) findViewById(R.id.editText2);

		button1.setOnClickListener(new OnClickListener() {
			int i;

			@Override
			public void onClick(View v) {

				boolean flag = false;
				// ͨ���������ݵ���ʽ�ж�������ʺź������Ƿ���ȷ
				username = (String) editText1.getText().toString();
				String userpass = (String) editText2.getText().toString();
				TextView textView1 = (TextView) findViewById(R.id.textView3);
				TextView textView2 = (TextView) findViewById(R.id.textView4);
				for (int i = 0; i < Data.USER.length; i++) {
					if (username.equals(Data.USER[i][0])) {// �ж��ʺ��Ƿ���ȷ
						if (userpass.equals(Data.USER[i][1])) { // �ж������Ƿ���ȷ
							username = Data.USER[i][2]; // ��ȡ�ǳ�
							flag = true; // ����־��������Ϊtrue
							break; // ����forѭ��
						}
					}
				}

				if (flag) {
					Toast.makeText(loginView.this, "��½�ɹ���", Toast.LENGTH_SHORT)
							.show();
					Intent intent = new Intent(loginView.this, arrge.class); // ����Ҫ��ʾActivity��Ӧ��Intent����
					Bundle bundle = new Bundle(); // ����һ��Bundle�Ķ���bundle
					bundle.putString("username", username); // �����ǳ�
					intent.putExtras(bundle); // �����ݰ���ӵ�intent������
					startActivity(intent); // ����һ���µ�Activity
					// loginView.this.finish();
				} else {
					if (username.equals("") || userpass.equals("")) {
						if ("".equals(username)) {
							Toast.makeText(loginView.this, "����û�������û�����",
									Toast.LENGTH_SHORT).show();
						}
						if ("".equals(userpass)) {
							Toast.makeText(loginView.this, "����û���������룡",
									Toast.LENGTH_SHORT).show();
						}

					} else {
						Toast.makeText(loginView.this, "��������ʺŻ��������",
								Toast.LENGTH_SHORT).show();
						Toast.makeText(loginView.this,
								"�û�����������������������ֵĺ������ֵ�ƴ��Ϊ�û�������Ϊ123456�����Գɹ���¼",
								Toast.LENGTH_LONG).show();
						textView1.setText(username);
						textView2.setText(userpass);
					}

				}

				// username = (String) editText1.getText().toString();
				// String userpass = (String) editText2.getText().toString();
				// TextView textView1 = (TextView) findViewById(R.id.textView3);
				// TextView textView2 = (TextView) findViewById(R.id.textView4);
				// for (int j = 0; j < user.length; j++) {
				//
				// if (user[j].equalsIgnoreCase(username)
				// && pass.equalsIgnoreCase(userpass)) {
				//
				// Toast.makeText(loginView.this, "��¼�ɹ�",
				// Toast.LENGTH_SHORT).show();
				// i = 1;
				// Intent intent7 = new Intent(loginView.this, arrge.class);
				// textView1.setText("�û���" + username + "��¼�ɹ���");
				// Bundle bundle=new Bundle();
				// bundle.putCharSequence("username", username);
				// intent7.putExtras(bundle);
				// startActivity(intent7);
				// loginView.this.finish();
				//
				// break;
				//
				// //
				// username==(String)user[0]||username==(String)user[1]||username==(String)user[2]&&userpass==(String)pass
				//
				// } else {
				// i = 0;
				// textView1.setText(username);
				// textView2.setText(userpass);
				//
				// }
				// }
				// if (i == 0) {
				// Toast.makeText(loginView.this,
				// "�û�����������������������ֵĺ������ֵ�ƴ��Ϊ�û�������Ϊ123456�����Գɹ���¼",
				// Toast.LENGTH_SHORT).show();
				// }

			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				editText1.setText(null);
				editText2.setText(null);
				Toast.makeText(loginView.this, "ע�Ṧ����δʵ��", Toast.LENGTH_LONG)
						.show();
			}
		});

	}

	public void menuAction2() {
		Dialog alertDialog = new AlertDialog.Builder(loginView.this)
				.setTitle("����")
				.setMessage(
						"ԭ���������ֽ�:SignMan��\n����Ӧ����ʽ����Ϊ:collection store.\nӢ�ķ��벻׼ȷ�ɡ������˼�����һ���������Ա�����ס�����⼸����֮������ã�������š�����\n"
								+ "ϣ���ⶫ���������Ҽ����ж�������ȥ��\n��˵���������ֻ�����Ǽ����˵��û������ܵ�¼��\nԸ���ǵ������쳤�ؾã�\n20140401�����˽ڣ���������\n��ʵ�����ֻ������" +
								"��ͬʱҲ����һ�����԰壬�Ժ�����ʲô���°������İ�֮��Ļ������Էŵ������棬˵��������Щ������������û�˻�Ц�㣬�е�ֻ���Ƕ��㣬����㣡\n" +
								"������ֻ���ҵ��뷨�����ڻ�ûѧ����׿�����̣�����ɶҲʵ�ֲ��ˣ��������������������ġ�	QQ���䣺1018795480@qq.com")
				.setIcon(R.drawable.ic_launcher)
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				}).create();
		alertDialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		super.onMenuItemSelected(featureId, item);

		switch (item.getItemId()) {
		case R.id.action_settings3:
			finish();
			break;
		case R.id.action_settings2:
			menuAction2();
			break;

		}

		return true;
	}
}
