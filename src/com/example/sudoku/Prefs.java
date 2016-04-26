package com.example.sudoku;

import com.example.sudoku.R;

import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class Prefs extends PreferenceActivity {
	public static int textsize=25;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);

		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		PreferenceManager manager = getPreferenceManager();
		// ����android:key��ָ�������ƣ��൱��id������ȡ��ѡ��
		ListPreference listPreference = (ListPreference) manager.findPreference("textsize");
		Log.i("�洢��ֵΪ", ""+listPreference.getValue());
		textsize=Integer.parseInt(listPreference.getValue());
	}
	public static boolean getBackMusic(Context context){
		return	PreferenceManager.getDefaultSharedPreferences(context).getBoolean("music",true);
	}
	public static boolean getSoundSet(Context context){
		return	PreferenceManager.getDefaultSharedPreferences(context).getBoolean("sound",true);
	}

}
