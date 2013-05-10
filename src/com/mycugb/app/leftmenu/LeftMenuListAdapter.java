package com.mycugb.app.leftmenu;

import java.util.List;

import com.mycugb.app.R;
import com.mycugb.app.model.LeftMenuGroupItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/** 
* @author hendery 1293005282@qq.com
* @time 2013-5-10
* ×ó²à²Ëµ¥µÄÊÊÅäÆ÷
*/ 
public class LeftMenuListAdapter extends BaseExpandableListAdapter
{
	private Context context;
	private List<LeftMenuGroupItem> list;
	private LayoutInflater inflater;

	public LeftMenuListAdapter(Context context,List<LeftMenuGroupItem> list)
	{
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(this.context);
	}
	@Override
	public Object getChild(int group, int child)
	{
		return list.get(group).getGroupList().get(child);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
			View convertView, ViewGroup parent)
	{
		ChildView childView;
		if(convertView==null)
		{
			convertView = inflater.inflate(R.layout.left_menu_item_layout, null);
			childView = new ChildView();
			childView.icon = (ImageView) convertView.findViewById(R.id.left_menu_item_icon);
			childView.name = (TextView)convertView.findViewById(R.id.left_menu_item_name);
			convertView.setTag(childPosition);
		}
		else {
			childView = (ChildView)convertView.getTag();
		}
		LeftMenuGroupItem item = list.get(groupPosition).getGroupList().get(childPosition);
		if(item!=null)
		{
			childView.icon.setImageResource(item.getIconId());
			childView.name.setText(item.getName());
		}
//		if(groupPosition == LeftMenuLayout.choodeGroupId&&childPosition==LeftMenuLayout.chooseChildId)
//		{
//			convertView.setBackgroundResource(R.drawable.leftmenu_list_item_pressed);
//		}
		return convertView;
	}

	private class ChildView
	{
		ImageView icon;
		TextView name;
	}
	@Override
	public int getChildrenCount(int groupPosition)
	{
		return list.get(groupPosition).getGroupList().size();
	}

	@Override
	public Object getGroup(int groupPosition)
	{
		return list.get(groupPosition);
	}

	@Override
	public int getGroupCount()
	{
		return list.size();
	}

	@Override
	public long getGroupId(int groupPosition)
	{
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
			ViewGroup parent)
	{
		GroupView groupView;
		if(convertView==null)
		{
			convertView = inflater.inflate(R.layout.left_menu_group_layout, null);
			groupView = new GroupView();
			groupView.name = (TextView)convertView.findViewById(R.id.left_menu_group_name);
			convertView.setTag(groupView);
		}
		else {
			groupView = (GroupView)convertView.getTag();
		}
		groupView.name.setText(list.get(groupPosition).getName());
		return convertView;
	}

	private class GroupView
	{
		TextView name;
	}
	
	@Override
	public boolean hasStableIds()
	{
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return true;
	}

}
