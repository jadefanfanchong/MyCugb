package com.mycugb.app.model;

import java.util.List;

/**
 * 左侧菜单的子项目实体类
* @author hendery 1293005282@qq.com
* @time 2013-5-10
 */
public class LeftMenuGroupItem
{
	private int id;
	private String name;//item名称 如地大新闻
	private int iconId;//item图标Id
	private List<LeftMenuGroupItem> groupList;//子项group列表
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getIconId()
	{
		return iconId;
	}
	public void setIconId(int iconId)
	{
		this.iconId = iconId;
	}
	public List<LeftMenuGroupItem> getGroupList()
	{
		return groupList;
	}
	public void setGroupList(List<LeftMenuGroupItem> groupList)
	{
		this.groupList = groupList;
	}


}
