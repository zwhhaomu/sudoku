package com.example.sudoku;

import com.example.sudoku.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

	private float width, height;
	private int i,j;
	public String[][] puzzle;
	Rect selRect=new Rect();
	int selX,selY;
	public MyView(Context context) {
		super(context);
		 puzzle = new String[][]{
					{"1"," "," "," "," "," "," "," "," "},
					{"2"," "," "," "," "," "," "," "," "},
					{"3"," "," "," "," "," "," "," "," "},
					{"4"," "," "," "," "," "," "," "," "},
					{"5"," "," "," "," "," "," "," "," "},
					{"6"," "," "," "," "," "," "," "," "},
					{"7"," "," "," "," "," "," "," "," "},
					{"8"," "," "," "," "," "," "," "," "},
					{"9"," "," "," "," "," "," "," "," "},
			};
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		// ���û���Canvas�ı���ɫΪ��ɫ
		// canvas.drawColor(R.color.game_background);
		canvas.drawColor(Color.GRAY);
		// ʵ��������
		Paint paint = new Paint();
		// ��ȥ���ʵľ��
		paint.setAntiAlias(true);
		// ���û��ʵ���ɫ
		paint.setColor(Color.GREEN);
		// ���û��ʵ���ʽΪ���ĵ�
		paint.setStyle(Paint.Style.FILL);
		// ���û��ʵĴ�ϸ���
		paint.setStrokeWidth(1);
		// ���ƾŹ���
		
		// // ��ʦ����
		// // ���ƾŹ�������
		for (i = 0; i <= 9; i++) {
			canvas.drawLine(0, i * height, getWidth(), i * height, paint);
			canvas.drawLine(i * width, 0, i * width, getHeight(), paint);
		}
		
		paint.setColor(Color.YELLOW);
		paint.setStrokeWidth(3);
		// ���ƴ�����
		for (i = 0; i <= 9; i = i + 3) {
			canvas.drawLine(0, i * height, getWidth(), i * height, paint);
			canvas.drawLine(i * width, 0, i * width, getHeight(), paint);
		}
		//��һ�е�����
		//{"1"," "," "," "," "," "," "," "," "},
		Paint frontPaint = new Paint();
		frontPaint.setColor(Color.RED);
/*		int textsize=25;
		textsize=Prefs.getListItemSelected(getContext());
		Log.i("info", String.valueOf(textsize))*/;
		
		frontPaint.setTextSize(Prefs.textsize);
	/*	{"1"," "," "," "," "," "," "," "," "},
		{"2"," "," "," "," "," "," "," "," "},
		{"3"," "," "," "," "," "," "," "," "},
		{"4"," "," "," "," "," "," "," "," "},
		{"5"," "," "," "," "," "," "," "," "},
		{"6"," "," "," "," "," "," "," "," "},
		{"7"," "," "," "," "," "," "," "," "},
		{"8"," "," "," "," "," "," "," "," "},
		{"9"," "," "," "," "," "," "," "," "},*/
		for(i=0;i<9;i++)
			for(j=0;j<9;j++){
				canvas.drawText(puzzle[i][j], j * width + (width * 0.3f),
						i* height+(height * 0.6f), frontPaint);
			}
		frontPaint.setColor(Color.argb(95, 0, 200, 200)); // ��͸���ȣ�red��green��blue��


		canvas.drawRect(selRect, frontPaint);
		
		
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		width=getWidth()/9f;
		height=getHeight()/9f;
		getRect(selX,selY,selRect);
		
	}
	public void setTitle(String t){
		int flag=0;
		for(int i=0;i<9;i++){
			if(puzzle[selY][i].equals(t))
			flag=1;		
			if(puzzle[i][selX].equals(t))
				flag=2;
		}
	
		for(int i=selX/3*3;i<selX/3*3+3;i++)
			for(int j=selY/3*3;j<selY/3*3+3;j++)
				if(puzzle[j][i].equals(t))
					flag=3;
			
		if(flag==1){
			Toast.makeText(getContext(), "������ͬ������ͬ��������", 8000).show();
			music.palySound(getContext(), R.raw.sound);
		}
		else if(flag==2){
			Toast.makeText(getContext(), "������ͬ������ͬ��������", 8000).show();
			music.palySound(getContext(), R.raw.sound);
			
		}
		else if(flag==3){
			Toast.makeText(getContext(), "������ͬ���Ź�������ͬ��������", 8000).show();
			music.palySound(getContext(), R.raw.sound);
		}
		else
			puzzle[selY][selX]=t;
	}
	public void getRect(int x,int y,Rect selRect){
		selRect.set((int) (x*width)+1, (int) (y*height)+1, (int) ((x+1)*width)-1, (int) ((y+1)*height)-1);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//return super.onTouchEvent(event);
		int x,y;
		x=(int) (event.getX()/width);
		y=(int) (event.getY()/height);
		selX=x;
		selY=y;
		invalidate(selRect);
		getRect(selX,selY,selRect);
		invalidate(selRect);
		new KeyPad(getContext(), this).show();
		return(false);
		
	}
}
