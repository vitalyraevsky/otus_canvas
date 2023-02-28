package com.otus.advancedcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CustomViewGestures
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

/*
    private val scaleGestureDetector = ScaleGestureDetector(context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor // 0.97...1.03
            invalidate()
            return true
        }
    })
*/

    private val generalGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            scale *= 1.1f
            invalidate()
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            scale *= 0.9f
            invalidate()
            return true
        }
    })

    private val androidIcon: Drawable = resources.getDrawable(R.drawable.ic_android_black_24dp, null).also {
        it.setBounds(0, 0, it.intrinsicWidth, it.intrinsicHeight)
    }

    var imgPosX = 0f
    var imgPosY = 0f
    var scale = 1f

    private var lastTouchX = 0f
    private var lastTouchY = 0f

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        imgPosX = width / 2f
        imgPosY = height / 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.scale(scale, scale, imgPosX - androidIcon.intrinsicWidth / 2, imgPosY - androidIcon.intrinsicHeight / 2)
        canvas.translate(imgPosX - androidIcon.intrinsicWidth / 2, imgPosY - androidIcon.intrinsicHeight / 2)
        androidIcon.draw(canvas)
    }
    /*
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.scale(scale, scale, imgPosX - androidIcon.intrinsicWidth / 2, imgPosY - androidIcon.intrinsicHeight / 2)
         Log.d("scale", scale.toString())
        canvas.translate(imgPosX - androidIcon.intrinsicWidth / 2, imgPosY - androidIcon.intrinsicHeight / 2)
        androidIcon.draw(canvas)
    }*/

    override fun onTouchEvent(event: MotionEvent): Boolean {
        (parent as ViewGroup).requestDisallowInterceptTouchEvent(true)
        Log.d("child", "on touch event")

        val ret = generalGestureDetector.onTouchEvent(event)

/*
        if(event.pointerCount > 1)
            return false
*/

        if (event.action == MotionEvent.ACTION_DOWN
/*
            && (event.x in imgPosX..(imgPosX + androidIcon.intrinsicWidth))
            && (event.y in imgPosY..(imgPosY + androidIcon.intrinsicHeight))
*/
        ) {
            lastTouchX = event.x
            lastTouchY = event.y
            return true
        } else if (event.action == MotionEvent.ACTION_MOVE) {
            if(ret) return true

            val dx = event.x - lastTouchX
            val dy = event.y - lastTouchY

/*
            imgPosX += dx
            imgPosY += dy
*/

            lastTouchX = event.x
            lastTouchY = event.y

            invalidate()
            return true
        } else {
            return false
        }

        // ACTION_DOWN (true) -> ACTION_MOVE (true) -> ACTION_UP
        // ACTION_DOWN (true) -> ACTION_MOVE (false)
        // ACTION_DOWN (false)
    }
    /*override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d("child", "on touch event")
        scaleGestureDetector.onTouchEvent(event)
        generalGestureDetector.onTouchEvent(event)

        if (event.action == MotionEvent.ACTION_DOWN) {
            lastTouchX = event.x
            lastTouchY = event.y
        } else if (event.action == MotionEvent.ACTION_MOVE) {
            val dx = event.x - lastTouchX
            val dy = event.y - lastTouchY

            imgPosX += dx
            imgPosY += dy

            lastTouchX = event.x
            lastTouchY = event.y

            invalidate()
        }

        return true
    }*/
}