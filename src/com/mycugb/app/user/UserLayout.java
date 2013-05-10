package com.mycugb.app.user;

import com.mycugb.app.R;
import com.mycugb.app.ui.base.HorizontalScrollContainer.OnOpenListener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/**
 * 
* @author hendery 1293005282@qq.com
* @time 2013-5-10
* 用户账户信息界面类
 */
public class UserLayout extends FrameLayout
{
	public UserLayout(Context context)
	{
		super(context);
		setUpView();
	}
	
	private OnOpenListener listener;
	private ImageView gobackImageView;
	
	private void setUpView()
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.user_layout, null);
		addView(layout);
		gobackImageView = (ImageView)layout.findViewById(R.id.go_back);
		gobackImageView.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				if(listener!=null)
				{
					listener.open();
				}
			}
		});
	}
	public void setOnOpenListener(OnOpenListener listener)
	{
		this.listener = listener;
	}

}
