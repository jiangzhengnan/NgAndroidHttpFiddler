package com.ng.ngcommon.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.ng.ngcommon.R;


/**
 * Created by nangua on 2016/5/21.
 */
public class NGHorizontalScrollCursor extends View implements ViewPager.OnPageChangeListener{
    private Context context;
    //传入的Viewpager
    private ViewPager mViewPager;
    private float lineStartX;
    private int lastPosition = 0 ;
    private float lineScale = 0 ; //Page移动的比例
    private float lineEndX = 0  ;
    //在XML中设定的参数
    private int width = 0;//控件总宽度
    private int height = 0;//控件总高度
    private int padingLeft = 0;//设置的padingLeft
    private int padingRight = 0;//设置的padingRight

    //间隔
    private int space   ;//默认为0
    //指定的页面个数
    private int count = 2;//!!!这里后面应该改为set方法得到,默认为1

    //Cursor的画笔
    private Paint linePaint;

    //测量参数
    private void measureSize(){
        width = getWidth(); //得到宽度
        DEFAULT_CURSOR_WIDTH = width/count ;
        strX  = new float[count];
        for (int i = 0;i<count;i++) {
            strX[i] = DEFAULT_CURSOR_WIDTH*i ;
        }


        height = getHeight();//得到设定的高度
        padingLeft = getPaddingLeft();   //得到的是40
        padingRight = getPaddingRight();  //得到padingRight
    }

    private int DEFAULT_CURSOR_WIDTH  ;//默认游标宽度
    private float [] strX  ;

    /**
     * 测量下划线的位置
     */
    private void measureLineSize(){
        lineStartX = strX[lastPosition]   + (DEFAULT_CURSOR_WIDTH   )* lineScale + space/2;
        if (mViewPager!=null) {
            if ((lastPosition + 1) == mViewPager.getAdapter().getCount()) {
                lineEndX = strX[lastPosition] + DEFAULT_CURSOR_WIDTH - space / 2;
            } else {
                lineEndX = strX[lastPosition] + DEFAULT_CURSOR_WIDTH + (DEFAULT_CURSOR_WIDTH) * lineScale - space / 2;
            }
        }
    }

    /*
     * 初始化画笔
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs){
        this.context = context ;
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.NGHorizontalScrollCursor);

        int cursorspace = t.getInt(R.styleable.NGHorizontalScrollCursor_space, 0);
        space = cursorspace;
        int cursorColor = t.getColor(R.styleable.NGHorizontalScrollCursor_cursorcolor, Color.BLACK);
        t.recycle();
        linePaint = new Paint();
        linePaint.setColor(cursorColor);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(50);
    }

    /**
     * 设置游标间距
     * @param space
     */
    public void setspace(int space){
        this.space = space ;
    }


    public NGHorizontalScrollCursor(Context context) {
        super(context);
    }

    public NGHorizontalScrollCursor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public NGHorizontalScrollCursor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        measureSize();  //测量数值
        measureLineSize();//测量下划线的位置
        drawLine(canvas);//画下划线

    }

    private void drawLine(Canvas canvas){
        canvas.drawLine(lineStartX, height, lineEndX, height, linePaint);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.lastPosition = position ;
        lineScale = positionOffset ;
        invalidate();
    }

    @Override
    public void onPageSelected(int position) {
        callback.CheckPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setViewPager(ViewPager mViewPager){
        this.mViewPager = mViewPager;
        if (this.mViewPager != null) {
            this.mViewPager.setOnPageChangeListener(this);
        }
        count = mViewPager.getAdapter().getCount();
    }


    //回调接口实例
    onViewPagerChanggedListner callback;

    public void setcallback(onViewPagerChanggedListner callback) {
        this.callback = callback;
    }

    //回调接口
    public interface onViewPagerChanggedListner {
        void CheckPage(int position);
    }
}
