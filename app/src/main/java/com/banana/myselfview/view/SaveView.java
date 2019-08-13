package com.banana.myselfview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.banana.myselfview.R;

/**
 * @anthor: Banana
 * @function:
 * @date: 2019/8/13
 */
public class SaveView extends View {

    private Canvas canvas;

    private Paint mPaint;

    public SaveView(Context context) {
        super(context);
        init();
    }

    public SaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SaveView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPorterDuffColorFilter(canvas);
    }

    private void saveMatrix(Canvas canvas) {
        //绘制蓝色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawRect(0, 0, 200, 200, mPaint);
        //保存
        canvas.save();
        //裁剪画布,并绘制红色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        //平移.
        canvas.translate(100, 0);
        //缩放.
        canvas.scale(0.5f, 0.5f);
        //旋转
        canvas.rotate(-45);
        //倾斜
        canvas.skew(0, 0.5f);
        canvas.drawRect(0, 0, 200, 200, mPaint);
        //恢复画布
        canvas.restore();
        //绘制绿色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        canvas.drawRect(0, 0, 50, 200, mPaint);
    }

    private void saveClip(Canvas canvas) {
        //绘制蓝色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawRect(0, 0, 200, 200, mPaint);
        //保存.
        canvas.save();
        //裁剪画布,并绘制红色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        canvas.clipRect(150, 0, 200, 200);
        canvas.drawRect(0, 0, 200, 200, mPaint);
        //恢复画布
        canvas.restore();
        //绘制绿色矩形
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        canvas.drawRect(0, 0, 50, 200, mPaint);
    }

    private void drawColorMatrixFilter(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //1,得到一个颜色矩阵
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.5f);
        //2.通过颜色矩阵构建ColorMatrixColorFilter对象
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        Paint matrixPaint = new Paint();
        //3.把构建的对象设置给Paint
        matrixPaint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, 0, 0, matrixPaint);
    }

    private void drawLightingColorFilter(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //1.构建一个LightingColorFilter
        LightingColorFilter lightingColorFilter = new LightingColorFilter(3, 0);
        Paint matrixPaint = new Paint();
        //2.设置给画笔
        matrixPaint.setColorFilter(lightingColorFilter);
        //3.绘制
        canvas.drawBitmap(bitmap, 0, 0, matrixPaint);
    }

    private void drawPorterDuffColorFilter(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
