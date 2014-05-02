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

//	String[] friends = new String[] { "����", "ʯ��", "����", "����", "����", "����", "ѩ��" };
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
		textView1.setText(bundle.getString("username")+"���~��ӭŶ��");
		textView1.setTextSize(20);
		
		
//		TextView textView2 = (TextView) findViewById(R.id.textViewB);
//		textView2.setText("����ˣ�����������~~~~~��������뷨�����ڣ��Ҷ���֪���Ӻ������ˣ������Ժ�ѧ�������ɣ��һ����Ŭ����~~~~~~�ݣ�");
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				layout.simple_spinner_item, friends);
//		adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);
		
		
		final EditText editText=(EditText)findViewById(R.id.editText1);							
		final ListView listView=(ListView)findViewById(R.id.listViewA);
		final int image=R.drawable.ic_launcher;		  
		final String[] title=new String[]{"���԰���140412��ͨ�ˣ���������׼������������飬���źܿ��������������԰�鵽���ˣ������ң����ͣ�BJ��"};
		final List<Map<String,Object>> listItem=new ArrayList<Map<String,Object>>();
		for (int i = 0; i <title.length; i++) {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("image", image);
			map.put("title", title[i]);
			listItem.add(map);
		}
		final SimpleAdapter adapter1=new SimpleAdapter(this, listItem, R.layout.items,new String[]{"title","image"},new int[]{R.id.title,R.id.imageView1});
		listView.setAdapter(adapter1);
		
		
		//��ȡEditText�е������ַ�����ӵ�LISTVIEW��
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String inputText=editText.getText().toString();
				Toast.makeText(arrge.this, inputText, Toast.LENGTH_LONG).show();
				System.out.println("����¼���"+(inputTextCount-4)+"�Σ�");
				inputTextCount+=1;
				for (int i = 0; i <title.length; i++) {
					Map<String, Object>map1=new HashMap<String, Object>();
					map1.put("image", image);
					map1.put("title", bundle.getString("username")+"��"+inputText);
					listItem.add(map1);										
					
				}
				
				listView.setAdapter(adapter1);			
				
			}
		});
		
		
/*ʱ�ӳ�ʼ��*/		
//		chronometer.setBase(SystemClock.elapsedRealtime());
//		chronometer.setFormat("����ʱ�䣺%s");
//		chronometer.start();
/*ʱ�Ӽ���*/		
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
				Toast.makeText(arrge.this, "���ڽ�����Ϸ���뽫�ֻ������Դﵽ��õ�Ч��", Toast.LENGTH_SHORT).show();
				Intent intent4 = new Intent(arrge.this,Game.class);
				startActivity(intent4);
//				arrge.this.finish();

			}
		});
	
		

	}
	public void menuAction2() {
		Dialog alertDialog = new AlertDialog.Builder(arrge.this)
		.setTitle("����")
		.setMessage("ԭ���������ֽ�:SignMan��\n����Ӧ����ʽ����Ϊ:collection store.\nӢ�ķ��벻׼ȷ�ɡ������˼�����һ���������Ա�����ס�����⼸����֮������ã�������š�����\n"
								+ "ϣ���ⶫ���������Ҽ����ж�������ȥ��\n��˵���������ֻ�����Ǽ����˵��û������ܵ�¼��\nԸ���ǵ������쳤�ؾã�\n20140401�����˽ڣ���������\n��ʵ�����ֻ������" +
								"��ͬʱҲ����һ�����԰壬�Ժ�����ʲô���°������İ�֮��Ļ������Էŵ������棬˵��������Щ������������û�˻�Ц�㣬�е�ֻ���Ƕ��㣬����㣡\n" +
								"������ֻ���ҵ��뷨�����ڻ�ûѧ����׿�����̣�����ɶҲʵ�ֲ��ˣ��������������������ġ�	QQ���䣺1018795480@qq.com")
		.setIcon(R.drawable.ic_launcher)
		.setPositiveButton("ȷ��",
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

