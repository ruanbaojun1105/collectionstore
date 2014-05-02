package example.arrgetest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StartView extends Activity {
	 private Handler handler;
	 private Intent intent = new Intent("com.angel.Android.MUSIC");
	@SuppressLint("HandlerLeak")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startview);
		//start background music 
        startService(intent);
		final Animation rotate1 = AnimationUtils.loadAnimation(this,
				R.anim.rotate);
		final Animation rotate2 = AnimationUtils.loadAnimation(this,
				R.anim.translate);
		final Animation rotate3 = AnimationUtils.loadAnimation(this,
				R.anim.scale);
		
//		ImageView imageView1 = (ImageView) findViewById(R.id.imageViewA);
//		imageView1.startAnimation(rotate1);		
//		ImageView imageView2 = (ImageView) findViewById(R.id.imageViewB);
//		imageView2.startAnimation(rotate2);
//		ImageView imageView3 = (ImageView) findViewById(R.id.imageViewC);
//		imageView3.startAnimation(rotate3);
		
		findViewById();
		setListener();
		init();
		
		
		
	}

	protected void findViewById() {
		// 暂时不做任何操作
	}

	protected void setListener() {
		// 暂时不做任何操作
	}

	protected void init() {
		// 延迟1500毫秒发送消息到消息队列
		handler1.sendEmptyMessageDelayed(0, 3000);
	}
	Handler handler1 = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// 跳转到登录界面,并默认方式关闭当前界面
			startActivity(loginView.class);
			stopService(intent);
			defaultFinish();
		}
	};
	protected void startActivity(Class<?> cls) {
		startActivity(cls, null);
	}
	/** 含有Bundle通过Class跳转界面 **/
	protected void startActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	private void startmain() {

	
		Intent intent = new Intent(this, loginView.class);
		startActivity(intent);
		StartView.this.finish();
		
	}
	
	/** 带有右进右出动画的退出 **/
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	/** 默认退出 **/
	protected void defaultFinish() {
		super.finish();
	}
}