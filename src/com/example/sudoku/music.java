package com.example.sudoku;

import android.content.Context;
import android.media.MediaPlayer;

public class music {
	private static MediaPlayer mp=null;
	private static MediaPlayer mmsound=null;
	//private static MediaPlayer mmsound=null;
	/*
	 * �����������ֲ��ţ�context�����ֲ���ʱ�������Ļ�����
	 * resources��Ҫ���ŵ�������Դ�ļ�
	* */
	public static void paly(Context context,int resources){
		stop(context);//����ָ������֮ǰ�Ȱ������������ý��ֹͣ
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
