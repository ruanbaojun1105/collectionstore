package example.arrgetest;

import android.os.Bundle;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class firstView extends Activity {

	final int[] imageId = new int[] { R.drawable.wp01, R.drawable.wp02,
			R.drawable.wp03, R.drawable.wp04, R.drawable.wp05 };

	int i;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstview);
		Button button = (Button) findViewById(R.id.buttonA);
		@SuppressWarnings("deprecation")
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		//baseadapter适配器配置，绑定gallery
		BaseAdapter adapter = new BaseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView;
				if (convertView == null) {
					imageView = new ImageView(firstView.this);
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);
					imageView
							.setLayoutParams(new Gallery.LayoutParams(330, 510));
					TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
					imageView.setBackgroundResource(typedArray.getResourceId(
							R.styleable.Gallery_android_galleryItemBackground,
							0));
					imageView.setPadding(5, 0, 5, 0);
				} else {
					imageView = (ImageView) convertView;

				}
				imageView.setImageResource(imageId[position]);
				return imageView;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}
		};
		gallery.setAdapter(adapter);
		gallery.setSelection(imageId.length / 2);
		/* 点击图片显示第几张的监听事件。 */
		/*
		 * // gallery.setOnItemClickListener(new OnItemClickListener() { // //
		 * @Override // public void onItemClick(AdapterView<?>parent, View view,
		 * int position, // long id) { // // TODO Auto-generated method stub //
		 * Toast.makeText(firstView.this,
		 * "你选中了"+String.valueOf(position+1)+"张图片", Toast.LENGTH_LONG).show();
		 * // } // });
		 */

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent0 = new Intent(firstView.this, entArrge.class);

				startActivity(intent0);
				firstView.this.finish();

			}
		});

	}

	@Override
	// 菜单事件监听
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void menuAction2() {
		Dialog alertDialog = new AlertDialog.Builder(firstView.this)
				.setTitle("关于")
				.setMessage(
						"原来打算名字叫:SignMan、\n现在应该正式改名为:collection store.\n英文翻译不准确吧。大概意思这就是一个网络留言薄，留住我们这几个人之间的美好，都珍藏着。。。\n"
								+ "希望这东西还能让我继续有动力做下去。\n先说明：这软件只有我们几个人的用户名才能登录。\n愿我们的友谊天长地久！\n20140401（愚人节）——宝军")
				.setIcon(R.drawable.ic_launcher)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				}).create();
		alertDialog.show();

	}

	// 菜单入口
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
