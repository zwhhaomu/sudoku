package com.example.sudoku;



import com.example.sudoku.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	//����˵�ѡ��
	private static final int ITEM1 = Menu.FIRST;
	private static final int ITEM2 = Menu.FIRST+1;
	private TextView myText;
	//�����ĸ���ť
	private Button bt_begin,bt_continue,bt_exit,bt_about;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//����ʼ��Ϸ��������Ϸ�����ڡ��˳��ĸ���ťʵ����
		bt_begin=(Button)findViewById(R.id.gamebeging);
		bt_continue=(Button)findViewById(R.id.gamecontinue);
		bt_exit=(Button)findViewById(R.id.gameexit); 
		bt_about=(Button)findViewById(R.id.gamesetting);
		//���ĸ���ť���¼�ʵ�ּ��� 
		bt_begin.setOnClickListener(this);
		bt_continue.setOnClickListener(this);
		bt_exit.setOnClickListener(this);
		bt_about.setOnClickListener(this);
		myText=(TextView)findViewById(R.id.mytext);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	//ʵ�ֵ����¼��Ĵ���
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.gameexit:
			exitGameDialog();
			break;	
		case R.id.gamesetting:
			Intent intent01=new Intent();
			intent01.setClass(this,About.class);
			startActivity(intent01);
			break;
		case R.id.gamebeging:
			startNewGame();
			break;
		case R.id.gamecontinue:
			break;
		}
 
	}

	private void startNewGame(){
		Intent intent=new Intent(this,Game.class);
		startActivity(intent);
	}

	private void exitGameDialog() {
		// �����Ի���
		AlertDialog.Builder exit_game=new AlertDialog.Builder(this);
		exit_game.setMessage("ȷ��Ҫ�˳�").setCancelable(false);
		exit_game.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		exit_game.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				return;
			}
		});
		AlertDialog alert=exit_game.create();
		alert.show();
	}
	
	//ͨ�������Ĳ˵���������
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO Auto-generated method stub
			//super.onCreateContextMenu(menu, v, menuInfo);
			menu.add(0,ITEM1,0,"��������");
			menu.add(0,ITEM2,0,"����");
		}

		@Override
		public boolean onContextItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			switch(item.getItemId()){
			case ITEM1:
				break;
			case ITEM2:
				break;
			default:
				return super.onOptionsItemSelected(item); 
			}
			return true;	
		}
}