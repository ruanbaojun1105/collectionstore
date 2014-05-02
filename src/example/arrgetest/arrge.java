package example.arrgetest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.R.layout;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class arrge extends Activity {

//	String[] friends = new String[] { "安华", "石初", "兵兵", "建飞", "俊林", "永生", "雪瑞" };
	int inputTextCount=5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arrage);
		final Button button1 = (Button) findViewById(R.id.buttonA);
		final Button button2 = (Button) findViewById(R.id.buttonB);
	
		
		Intent intent=getIntent();
		final Bundle bundle=intent.getExtras();
		TextView textView1 = (TextView) findViewById(R.id.textViewA);
		textView1.setText(bundle.getString("username")+"你好~欢迎哦！");
		textView1.setTextSize(20);
		
		
//		TextView textView2 = (TextView) findViewById(R.id.textViewB);
//		textView2.setText("别点了，就做到这了~~~~~从最初的想法到现在，我都不知道从何入手了，看看以后学的怎样吧，我会继续努力的~~~~~~拜！");
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				layout.simple_spinner_item, friends);
//		adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);
		
		
		final EditText editText=(EditText)findViewById(R.id.editText1);							
		final ListView listView=(ListView)findViewById(R.id.listViewA);
		final int image=R.drawable.ic_launcher;		  
		final String[] title=new String[]{"留言板在140412开通了，现在正在准备看网络编程这块，相信很快真正的网络留言板块到来了，相信我，加油，BJ！"};
		final List<Map<String,Object>> listItem=new ArrayList<Map<String,Object>>();
		for (int i = 0; i <title.length; i++) {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("image", image);
			map.put("title", title[i]);
			listItem.add(map);
		}
		final SimpleAdapter adapter1=new SimpleAdapter(this, listItem, R.layout.items,new String[]{"title","image"},new int[]{R.id.title,R.id.imageView1});
		listView.setAdapter(adapter1);
		
		
		//获取EditText中的输入字符，添加到LISTVIEW。
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String inputText=editText.getText().toString();
				Toast.makeText(arrge.this, inputText, Toast.LENGTH_LONG).show();
				System.out.println("点击事件第"+(inputTextCount-4)+"次：");
				inputTextCount+=1;
				for (int i = 0; i <title.length; i++) {
					Map<String, Object>map1=new HashMap<String, Object>();
					map1.put("image", image);
					map1.put("title", bundle.getString("username")+"："+inputText);
					listItem.add(map1);										
					
				}
				
				listView.setAdapter(adapter1);			
				
			}
		});
		
		
/*时钟初始化*/		
//		chronometer.setBase(SystemClock.elapsedRealtime());
//		chronometer.setFormat("已用时间：%s");
//		chronometer.start();
/*时钟监听*/		
//		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
//
//					@Override
//					public void onChronometerTick(Chronometer chronometer) {
//						if (SystemClock.elapsedRealtime()- chronometer.getBase() >= 1000) {
//							chronometer.stop();
//						}
//
//					}
//				});
		
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(arrge.this, "正在进入游戏，请将手机横屏以达到最好的效果", Toast.LENGTH_SHORT).show();
				Intent intent4 = new Intent(arrge.this,Game.class);
				startActivity(intent4);
//				arrge.this.finish();

			}
		});
	
		

	}
	public void menuAction2() {
		Dialog alertDialog = new AlertDialog.Builder(arrge.this)
		.setTitle("关于")
		.setMessage("原来打算名字叫:SignMan、\n现在应该正式改名为:collection store.\n英文翻译不准确吧。大概意思这就是一个网络留言薄，留住我们这几个人之间的美好，都珍藏着。。。\n"
								+ "希望这东西还能让我继续有动力做下去。\n先说明：这软件只有我们几个人的用户名才能登录。\n愿我们的友谊天长地久！\n20140401（愚人节）——宝军\n其实做这个只是无聊" +
								"，同时也想做一个留言板，以后大家有什么心事啊，无聊啊之类的话都可以放到这上面，说给我们这些朋友听，这里没人会笑你，有的只会是懂你，理解你！\n" +
								"不过这只是我的想法，现在还没学到安卓网络编程，现在啥也实现不了，后续会慢慢更新上来的。	QQ邮箱：1018795480@qq.com")
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}

