package example.arrgetest;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class entArrge extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ent);
		final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
		final Button button1 = (Button) findViewById(R.id.button1);
		final Button button2 = (Button) findViewById(R.id.button2);
		final TextView textView1 = (TextView) findViewById(R.id.textView1);
		final TextView textView2 = (TextView) findViewById(R.id.textView2);
		checkBox.setChecked(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		checkBox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (checkBox.isChecked()) {
					textView2.setText("您已同意条款");
					textView2.setTextColor(Color.BLUE);
					button1.setEnabled(true);
					button2.setEnabled(true);				
//					button2.setVisibility(View.VISIBLE);
					
				} 
				else {
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					textView2.setText("还在想什么？！快点击同意进入老男人们的世界！");
					textView2.setTextColor(Color.BLUE);
				}
//				button2.invalidate();

			}
		});
		button1.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(entArrge.this, "注册功能暂未实现", Toast.LENGTH_LONG).show();
				SoundPool soundPool = new SoundPool(1,
						AudioManager.STREAM_SYSTEM, 0);// 创建背景音乐实例
				soundPool.play(soundPool.load(entArrge.this, R.raw.play, 0),
						1, 1, 0, -1, 1);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(entArrge.this, loginView.class);
				startActivity(intent1);
				entArrge.this.finish();
				textView1.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

public void menuAction2() {
	Dialog alertDialog = new AlertDialog.Builder(entArrge.this)
	.setTitle("关于")
	.setMessage("原来打算名字叫:SignMan、\n现在应该正式改名为:collection store.\n英文翻译不准确吧。大概意思这就是一个网络留言薄，留住我们这几个人之间的美好，都珍藏着。。。\n" +
			"希望这东西还能让我继续有动力做下去。\n先说明：这软件只有我们几个人的用户名才能登录。\n愿我们的友谊天长地久！\n20140401（愚人节）——宝军")
	.setIcon(R.drawable.ic_launcher)
	.setPositiveButton("确定",
			new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog,
						int which) {
					// TODO Auto-generated method stub
				}
			}).create();
	alertDialog.show();



	
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
