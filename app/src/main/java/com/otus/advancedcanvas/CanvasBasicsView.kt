package com.otus.advancedcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView

class CanvasBasicsView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    val blackPaint : Paint
    val blackStrokePaint : Paint
    val blackStrokeAndFillPaint : Paint
    val dotPaint : Paint

    val rec = RectF()

    init {
        blackPaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 6f
        }

        blackStrokePaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 6f
            style = Paint.Style.STROKE
        }

        blackStrokeAndFillPaint = Paint().apply {
            color = Color.BLUE
            strokeWidth = 6f
            style = Paint.Style.FILL_AND_STROKE
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


/*
        canvas.drawLine(0f, 0f, midWidth, midHeight, blackPaint)
        canvas.drawPoint(midWidth, midHeight, dotPaint)
        canvas.drawCircle(midWidth, midHeight, 100f, blackStrokePaint)
*/
/*
        canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), 50f, 50f, blackStrokePaint)
        canvas.drawOval(0f, 0f, width.toFloat(), height.toFloat(), blackStrokePaint)
        canvas.drawArc(0f, 0f, width.toFloat(), height.toFloat(), 90f, 270f, true, blackStrokePaint)

        canvas.drawArc(rec, 180f, 120f, false, blackPaint)

*/

/*
        blackPaint.textSize = 60f
        blackPaint.textAlign = Paint.Align.RIGHT
        canvas.drawText("Hello", midWidth, midHeight, blackPaint)
*/

        /*

                canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), blackStrokePaint)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), 50f, 50f, blackStrokePaint)
                    canvas.drawOval(0f, 0f, width.toFloat(), height.toFloat(), blackStrokePaint)
                    canvas.drawArc(0f, 0f, width.toFloat(), height.toFloat(), 90f, 270f, true, blackStrokePaint)
                }*/

        /*//blackStrokePaint.color = Color.GREEN
        //rec.offset(100f, 100f)
        canvas.drawRect(rec, blackStrokePaint)
        canvas.drawRoundRect(rec, 50f, 50f, blackStrokePaint)
        canvas.drawOval(rec, blackStrokePaint)*/

    }
}