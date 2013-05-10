package com.mycugb.app.utils;

import android.app.Application;

/**
 * 应用程序的Application类存储一些全局文件和资源
 * @time 2013-5-10
 * @author hendery 1293005282@qq.com
 * 
 */
public class MyApplication extends Application
{

	private static MyApplication myApplication;

	@Override
	public void onCreate()
	{
		super.onCreate();
		myApplication = this;
	}


	public static MyApplication getInstance()
	{
		return myApplication;
	}

}
