package com.santalu.widget

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log

class AspectRatioImageView : AppCompatImageView {

  var ratio: Float = DEFAULT_RATIO

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init(context, attrs)
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    init(context, attrs)
  }

  private fun init(context: Context, attrs: AttributeSet?) {
    attrs?.let {
      val a = context.obtainStyledAttributes(it, R.styleable.AspectRatioImageView)
      ratio = a.getFloat(R.styleable.AspectRatioImageView_ari_ratio, DEFAULT_RATIO)
      a.recycle()
    }
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    var width = measuredWidth
    var height = measuredHeight

    if (width == 0 && height == 0) {
      return
    }

    if (width > 0) {
      height = (width * ratio).toInt()
    } else {
      width = (height / ratio).toInt()
    }

    Log.v("TAG", "width $width height $height ratio $ratio")

    setMeasuredDimension(width, height)
  }

  companion object {

    const val DEFAULT_RATIO = 1F
  }
}