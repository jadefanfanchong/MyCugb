package com.mycugb.app.treehole;

import com.mycugb.app.R;
import com.mycugb.app.ui.base.HorizontalScrollContainer.OnOpenListener;
import com.mycugb.app.utils.Constant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 
* @author hendery 1293005282@qq.com
* @time 2013-5-10
* 人人树洞界面
 */
public class TreeHoleLayout extends FrameLayout
{
	private OnOpenListener listener;
	private ImageView gobackImageView;
	private TextView headTextView;
	private ImageView headRightImageView;
	public TreeHoleLayout(Context context)
	{
		super(context);
		setUpView();
	}
	private void setUpView()
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.treehole_layout, null);
		addView(layout);
		gobackImageView = (ImageView)layout.findViewById(R.id.go_back);
		headTextView = (TextView)layout.findViewById(R.id.head_text);
		headRightImageView = (ImageView)layout.findViewById(R.id.head_right);
		headTextView.setText(Constant.TREE_HOLE_STRING);
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
