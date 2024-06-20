package com.jack.endroid.core.javabasic.annotation.inject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jack.endroid.annotationtester.R;

import androidx.annotation.Nullable;

public class InjectViewActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.tv)
    private TextView tv;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inject_view);
		InjectUtils.injectView(this);
//		this.tv = InjectViewActivity.this.findViewById(R.id.tv);
		tv.setText("我是通过注解&反射findViewById的！！！");
		tv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.tv: {
				Toast.makeText(InjectViewActivity.this, "tv is clicked", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}
}
