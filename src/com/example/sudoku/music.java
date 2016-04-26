package com.example.sudoku;

import android.content.Context;
import android.media.MediaPlayer;

public class music {
	private static MediaPlayer mp=null;
	private static MediaPlayer mmsound=null;
	//private static MediaPlayer mmsound=null;
	/*
	 * 控制启动音乐播放，context是音乐播放时的上下文环境，
	 * resources是要播放的音乐资源文件
	* */
	public static void paly(Context context,int resources){
		stop(context);//播放指定音乐之前先把上下文任意多媒体停止
		if(Prefs.getBackMusic(context)){
			mp=MediaPlayer.create(context, resources);
			mp.setLooping(true);
			mp.start();
		}
	}
	public static void stop(Context context) {
		if(mp!=null){
			mp.stop();
			mp.release();
			mp=null;
		}
	}
	public static void palySound(Context context,int resource){
		stop(context);
		if(Prefs.getSoundSet(context)){
			mmsound=MediaPlayer.create(context, resource);
			mmsound.start();
		}		
	}
}
