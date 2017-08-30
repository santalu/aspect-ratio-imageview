package com.santalu.aspectratioimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by santalu on 17/08/2017.
 */

public class AspectRatioImageView extends AppCompatImageView {

    @IntDef({ Aspect.WIDTH, Aspect.HEIGHT })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Aspect {
        int WIDTH = 0;
        int HEIGHT = 1;
        int AUTO = 2;
    }

    public static final int DEFAULT_RATIO = 1;

    private int mAspect;
    private float mAspectRatio;

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        switch (mAspect) {
            case Aspect.AUTO:
                if (height > width) {
                    if (width == 0) return;

                    mAspect = Aspect.WIDTH;
                    mAspectRatio = Math.round((double) height / width);
                    setMeasuredDimension((int) (height * mAspectRatio), height);
                } else {
                    if (height == 0) return;

                    mAspect = Aspect.HEIGHT;
                    mAspectRatio = Math.round((double) width / height);
                    setMeasuredDimension(width, (int) (width * mAspectRatio));
                }
                break;
            case Aspect.WIDTH:
                setMeasuredDimension((int) (height * mAspectRatio), height);
                break;
            case Aspect.HEIGHT:
            default:
                setMeasuredDimension(width, (int) (width * mAspectRatio));
                break;
        }
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        try {
            mAspect = a.getInt(R.styleable.AspectRatioImageView_ari_aspect, Aspect.HEIGHT);
            mAspectRatio = a.getFloat(R.styleable.AspectRatioImageView_ari_ratio, DEFAULT_RATIO);
        } finally {
            a.recycle();
        }
    }

    public void setAspectRatio(float ratio) {
        mAspectRatio = ratio;
        requestLayout();
    }

    public void setAspect(@Aspect int aspect) {
        mAspect = aspect;
        requestLayout();
    }

    public double getAspectRatio() {
        return mAspectRatio;
    }

    @Aspect public int getAspect() {
        return mAspect;
    }
}
