package com.example.achmadqomarudin.banksampah.penjual.fragment.slider;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * Created by Achmad Qomarudin on 12/09/2017.
 */

public class SliderView extends ViewPager {

    public static final int DEFAULT_SCROLL_DURATION = 200;
    public static final int SLIDE_MODE_SCROLL_DURATION = 1000;

    public SliderView(Context context) {
        super(context);
        init();
    }

    public SliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setDurationScroll(DEFAULT_SCROLL_DURATION);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //return true ini yg asli!

                /**Geser ketika disentuh*/
                ViewParent parent = getParent();
                // or get a reference to the ViewPager and cast it to ViewParent
                parent.requestDisallowInterceptTouchEvent(true);
                // let this view deal with the event or
                return SliderView.super.onTouchEvent(event);
            }
        });
    }

    public void setDurationScroll(int millis) {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new OwnScroller(getContext(), millis));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class OwnScroller extends Scroller {
        private int durationScrollMillis = 1;

        public OwnScroller(Context context, int durationScroll) {
            super(context, new DecelerateInterpolator());
            this.durationScrollMillis = durationScroll;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, durationScrollMillis);
        }
    }
}
