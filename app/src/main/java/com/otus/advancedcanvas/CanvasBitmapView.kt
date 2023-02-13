package com.otus.advancedcanvas

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView

class CanvasBitmapView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    val blackPaint : Paint
    val blackStrokePaint : Paint
    val dotPaint : Paint

    val rec = RectF()

    init {
        blackPaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 3f
        }

        blackStrokePaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 6f
            style = Paint.Style.STROKE
        }

        dotPaint = Paint().apply {
            color = Color.RED
            strokeWidth = 20f
        }

        rec.left = 0f
        rec.top = 0f
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        rec.bottom = height.toFloat()
        rec.right = width.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d("CanvasBasicsView", "onDraw")
        if (canvas == null) return

        val midHeight = height / 2f
        val midWidth = width / 2f

        canvas.drawRGB(255, 120, 120)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.android)

        val matrix = Matrix()
        //matrix.postScale(0.5f, 0.5f)
        //matrix.postRotate(45f)

        canvas.drawBitmap(bitmap, matrix, blackPaint)
    }
}