package example.arrgetest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends Activity {
	int[] imageIds = new int[] { R.drawable.shoe_ok, R.drawable.shoe_sorry,
			R.drawable.shoe_sorry };
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private TextView result;
	OnClickListener listener1;
	OnClickListener listener2;
	OnClickListener listener3;
	OnClickListener buttonClick;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*设置横屏*/
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.game);

		image1 = (ImageView) findViewById(R.id.imageView1);
		image2 = (ImageView) findViewById(R.id.imageView2);
		image3 = (ImageView) findViewById(R.id.imageView3);
		result = (TextView) findViewById(R.id.textView1);
		reset();
		image1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isRight(v, 0);
			}
		});

		image2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isRight(v, 1);
			}
		});

		image3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isRight(v, 2);
			}
		});
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				reset();
				result.setText(R.string.title);
				image1.setAlpha(255);
				image2.setAlpha(255);
				image3.setAlpha(255);
				image1.setImageDrawable(getResources().getDrawable(
						R.drawable.shoe_default));
				image2.setImageDrawable(getResources().getDrawable(
						R.drawable.shoe_default));
				image3.setImageDrawable(getResources().getDrawable(
						R.drawable.shoe_default));
				reset();
				image1.setEnabled(true);
				image2.setEnabled(true);
				image3.setEnabled(true);
			}
		});
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void reset() {
		for (int i = 0; i < 3; i++) {
			int temp = imageIds[i];
			int index = (int) (Math.random() * 2);
			imageIds[i] = imageIds[index];
			imageIds[index] = temp;
		}
	}

	private void isRight(View v, int index) {
		image1.setImageDrawable(getResources().getDrawable(imageIds[0]));
		image2.setImageDrawable(getResources().getDrawable(imageIds[1]));
		image3.setImageDrawable(getResources().getDrawable(imageIds[2]));
		image1.setAlpha(100);
		image2.setAlpha(100);
		image3.setAlpha(100);
		ImageView v1 = (ImageView) v;
		v1.setAlpha(255);
		if (imageIds[index] == R.drawable.shoe_ok) {
			result.setText("恭喜你，猜对了，祝你幸福！");
			image1.setEnabled(false);
			image2.setEnabled(false);
			image3.setEnabled(false);
			
		} else {
			result.setText("很抱歉，猜错了，要不要再试一次？");
			image1.setEnabled(false);
			image2.setEnabled(false);
			image3.setEnabled(false);
		}

	}
}
