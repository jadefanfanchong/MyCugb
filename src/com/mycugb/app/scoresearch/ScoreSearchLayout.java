package com.mycugb.app.scoresearch;

import com.mycugb.app.R;
import com.mycugb.app.ui.base.HorizontalScrollContainer.OnOpenListener;
import com.mycugb.app.utils.Constant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 
* @author hendery 1293005282@qq.com
* @time 2013-5-10
* 查询分数界面
 */
public class ScoreSearchLayout extends FrameLayout
{

	private OnOpenListener listener;
	private ImageView gobackImageView;
	private TextView headTextView;
	private ImageView headRightImageView;
	public ScoreSearchLayout(Context context)
	{
		super(context);
		setUpView();
	}

	private void setUpView()
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.score_search_layout, null);
		addView(layout);
		gobackImageView = (ImageView)layout.findViewById(R.id.go_back);
		headTextView = (TextView)layout.findViewById(R.id.head_text);
		headRightImageView = (ImageView)layout.findViewById(R.id.head_right);
		headTextView.setText(Constant.SCORE_SREACH_STRING);
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
