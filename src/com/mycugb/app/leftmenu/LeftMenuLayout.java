package com.mycugb.app.leftmenu;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mycugb.app.R;
import com.mycugb.app.model.LeftMenuGroupItem;
import com.mycugb.app.utils.Constant;

/**
 * 应用程序左侧面板的activity
 * @author hendery
 * @time 2013-05-10
 * 
 */
public class LeftMenuLayout extends FrameLayout
{

	private ImageView profile_photo;
	private TextView account_nickname;
	private ImageView account_back;
	private ExpandableListView left_menu_itemExpandableListView;
	private List<LeftMenuGroupItem> list = new ArrayList<LeftMenuGroupItem>();
	private String[] groupNames;// 左侧面板群组名数组
	private LeftMenuListAdapter adapter;
	private Context context;
	private OnChangeViewListener changeViewListener;
	private int groupPosition;// 用户点击item所属的group的position
	private int childPosition;// 用户点击item的position
	private LinearLayout user_info;// 头部容纳用户信息的layout
	public static int choodeGroupId = 0;
	public static int chooseChildId = 0;//记录用户选择的子项id用于改变背景颜色

	public LeftMenuLayout(Context context)
	{
		super(context);
		this.context = context;
		setUpView();
	}

	private void setUpView()
	{
		LayoutInflater inflater = LayoutInflater.from(context);
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.left_menu_layout, null);
		addView(layout);

		user_info = (LinearLayout) layout.findViewById(R.id.user_info);
		profile_photo = (ImageView) layout.findViewById(R.id.mycugb_account_photo);
		account_nickname = (TextView) layout.findViewById(R.id.mycugb_account_nickname);
		account_back = (ImageView) layout.findViewById(R.id.profile_back);
		left_menu_itemExpandableListView = (ExpandableListView) layout
				.findViewById(R.id.menu_item_listview);

		init();

	}

	private void init()
	{
		Resources resources = this.getResources();
		groupNames = resources.getStringArray(R.array.left_menu_group_names);// 从xml文件中获取群组名

		String[] newsGroup = resources.getStringArray(R.array.left_menu_news_group_item);// 新闻
		String[] toolsGroup = resources.getStringArray(R.array.left_menu_tools_group_item);// 实用工具
		String[] funGroup = resources.getStringArray(R.array.left_menu_fun_group_item);// 娱乐

		int[] newsIcons =
		{ android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_email };
		int[] toolsIcons =
		{ android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_email };
		int[] funIcons =
		{ android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_email };

		initGroup(Constant.NEWS, newsGroup, newsIcons);
		initGroup(Constant.TOOLS, toolsGroup, toolsIcons);
		initGroup(Constant.FUN, funGroup, funIcons);

		user_info.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Toast.makeText(getContext(), "你点击了用户信息", Toast.LENGTH_SHORT).show();
				if (changeViewListener != null)
				{
					choodeGroupId = -1;
					chooseChildId = -1;
					changeViewListener.onChangeView(Constant.USER_INFO);
				}
			}
		});
		adapter = new LeftMenuListAdapter(getContext(), list);
		left_menu_itemExpandableListView.setAdapter(adapter);
		for (int i = 0; i < list.size(); i++)
		{
			left_menu_itemExpandableListView.expandGroup(i);// 默认展开所有的group
		}

		left_menu_itemExpandableListView.setOnGroupClickListener(new OnGroupClickListener()
		{

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
					long id)
			{
				return true;
			}
		});

		left_menu_itemExpandableListView.setOnChildClickListener(new OnChildClickListener()
		{

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int group, int child,
					long id)
			{
				// if (changeViewListener == null)
				// return false;
				// groupPosition = group;
				// childPosition = child;
				// changeViewListener.onChangeView(groupPosition, childPosition);
				if (group == 0)
				{
					choodeGroupId = group;
					chooseChildId = child;
					switch (child)
					{
					case 0:
						changeViewListener.onChangeView(Constant.SHUDONG);
						break;
					case 1:
						changeViewListener.onChangeView(Constant.CUGB_NEWS);
						break;
					default:
						break;
					}
				} else if (group == 1)
				{
					choodeGroupId = group;
					chooseChildId = child;
					switch (child)
					{
					case 0:
						changeViewListener.onChangeView(Constant.CLASSROOM_SEARCH);
						break;
					case 1:
						changeViewListener.onChangeView(Constant.SCORE_SEARCH);
						break;
					default:
						break;
					}
				} else if (group == 2)//待确定子项具体内容
				{
					choodeGroupId = group;
					chooseChildId = child;
					switch (child)
					{
					case 0:

						break;
					case 1:
						break;
					default:
						break;

					}

				}
				return true;
			}
		});
	}

	/*
	 * 初始化group数据
	 */
	private void initGroup(int groupId, String[] names, int[] iconIds)
	{
		List<LeftMenuGroupItem> group = new ArrayList<LeftMenuGroupItem>();
		LeftMenuGroupItem groupItem = new LeftMenuGroupItem();
		groupItem.setId(groupId);
		groupItem.setName(groupNames[groupId]);
		LeftMenuGroupItem item;
		for (int i = 0; i < names.length; i++)
		{
			item = new LeftMenuGroupItem();
			item.setId(i);
			item.setName(names[i]);
			item.setIconId(iconIds[i]);
			group.add(item);
		}
		groupItem.setGroupList(group);
		list.add(groupItem);
	}

	public void setOnChangeViewListener(OnChangeViewListener listener)
	{
		this.changeViewListener = listener;
	}

	/*
	 * 选中item更改视图监视器
	 * 
	 * @author hendery
	 */
	public interface OnChangeViewListener
	{
		// public abstract void onChangeView(int group, int child);
		public abstract void onChangeView(int itemId);

	}

}
