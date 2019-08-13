package com.banana.myselfview.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

/**
 * @anthor: Banana
 * @function:
 * @date: 2019/8/12
 */
public class ChinaView extends View {

    private Canvas canvas;

    private Paint paint;

    private Path path;

    public ChinaView(Context context) {
        super(context);
        init();
    }

    public ChinaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChinaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChinaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        canvas=new Canvas();
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        path=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(100,500,980,1000,paint);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawLine(200,600,170,690,paint);
        canvas.drawLine(200,600,230,690,paint);
        canvas.drawLine(155,635,245,635,paint);
        canvas.drawLine(155,635,230,690,paint);
        canvas.drawLine(245,635,170,690,paint);

        drawSmallStar(245,540,canvas,paint);
        drawSmallStar(300,600,canvas,paint);
        drawSmallStar(300,680,canvas,paint);
        drawSmallStar(245,730,canvas,paint);

    }

    private void drawSmallStar(int x,int y,Canvas canvas,Paint paint){
        canvas.drawLine(x,y,x-12,y+30,paint);
        canvas.drawLine(x,y,x+13,y+30,paint);
        canvas.drawLine(x-17,y+10,x+18,y+10,paint);
        canvas.drawLine(x-17,y+10,x+13,y+30,paint);
        canvas.drawLine(x+18,y+10,x-12,y+30,paint);
    }
}
