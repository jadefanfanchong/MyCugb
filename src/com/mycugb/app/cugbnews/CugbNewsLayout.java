package com.mycugb.app.cugbnews;

import com.mycugb.app.R;
import com.mycugb.app.ui.base.HorizontalScrollContainer.OnOpenListener;
import com.mycugb.app.utils.Constant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 地大新闻的界面
 * @author hendery
 * @time 2013-05-10
 *
 */
public class CugbNewsLayout extends FrameLayout
{

	private OnOpenListener listener;
	private ImageView gobackImageView;
	private TextView headTextView;
	private ImageView headRightImageView;

	
	public CugbNewsLayout(Context context)
	{
		super(context);
		setUpView();
	}
	private void setUpView()
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cugbnews_layout, null);
		addView(layout);
		gobackImageView = (ImageView)layout.findViewById(R.id.go_back);
		headTextView = (TextView)layout.findViewById(R.id.head_text);
		headRightImageView = (ImageView)layout.findViewById(R.id.head_right);
		headTextView.setText(Constant.CUGB_NEWS_STRING);
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
