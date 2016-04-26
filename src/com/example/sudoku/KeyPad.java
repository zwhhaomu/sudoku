package com.example.sudoku;

import com.example.sudoku.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KeyPad extends Dialog implements android.view.View.OnClickListener {
	MyView fatherView;
	Button btn[]=new Button[9];
	public KeyPad(Context context,MyView fatherView) {
		super(context, R.style.Theme_dialog);		
		this.fatherView=fatherView;

		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keypad);
		findviewBtnid();
		for(int i=0;i<9;i++)
			btn[i].setOnClickListener(this);
	}
	private void findviewBtnid() {
		btn[0]=(Button) findViewById(R.id.keypad_1);
		btn[1]=(Button) findViewById(R.id.keypad_2);
		btn[2]=(Button) findViewById(R.id.keypad_3);
		btn[3]=(Button) findViewById(R.id.keypad_4);
		btn[4]=(Button) findViewById(R.id.keypad_5);
		btn[5]=(Button) findViewById(R.id.keypad_6);
		btn[6]=(Button) findViewById(R.id.keypad_7);
		btn[7]=(Button) findViewById(R.id.keypad_8);
		btn[8]=(Button) findViewById(R.id.keypad_9);

	}
	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.keypad_1:
			fatherView.setTitle("1");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_2:
			fatherView.setTitle("2");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_3:
			fatherView.setTitle("3");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_4:
			fatherView.setTitle("4");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_5:
			fatherView.setTitle("5");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_6:
			fatherView.setTitle("6");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_7:
			fatherView.setTitle("7");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_8:
			fatherView.setTitle("8");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		case R.id.keypad_9:
			fatherView.setTitle("9");
			//Toast.makeText(getContext(), "1", 8000).show();
			break;
		}
		dismiss();


	}

}
