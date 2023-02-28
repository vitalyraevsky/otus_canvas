package com.otus.advancedcanvas

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView

class CanvasMatrixView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    val blackPaint : Paint
    val blackStrokePaint : Paint
    val dotPaint : Paint

    val rec = RectF()
    val rectMiddle = RectF()
    val path = Path()
    val path1 = Path()
    val point = Point()
    val point1 = Point()
    val matrix0 = Matrix()

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

        rectMiddle.left = (width / 2 - 200).toFloat()
        rectMiddle.right = (width / 2 + 200).toFloat()
        rectMiddle.top = (height / 2 - 200).toFloat()
        rectMiddle.bottom = (height / 2 + 200).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d("CanvasBasicsView", "onDraw")
        if (canvas == null) return

        val midHeight = height / 2f
        val midWidth = width / 2f

        canvas.drawRGB(129, 120, 255)

        path.reset()
        path.moveTo(midWidth, midHeight)
        path.lineTo(midWidth + 100, midHeight)
        path.lineTo(midWidth + 100, midHeight + 100)
        path.close()


        matrix0.reset()
        matrix0.postScale(2f, 2f, midWidth, midHeight)
        matrix0.preRotate(45f, midWidth, midHeight)
        //path.transform(matrix0)


        canvas.drawPath(path, blackStrokePaint)

        // 1 2 0
        // 0 0 2
        // 1 1 1

        /*canvas.clipRect(midWidth - 100, midHeight - 100, midWidth + 100, midHeight + 100)
        path.reset()
        path.moveTo(midWidth - 200, midHeight - 200)
        path.addRect(rectMiddle, Path.Direction.CW)

        canvas.drawPath(path, blackPaint)*/

        /*matrix0.reset()
        matrix0.preTranslate(110f, 110f)
       // path.transform(matrix0)

        //blackStrokePaint.color = Color.RED
        //canvas.drawPath(path, blackStrokePaint)


        //matrix0.reset()
        matrix0.postRotate(45f, midWidth, midHeight)
        path.transform(matrix0)

        blackStrokePaint.color = Color.BLUE
        canvas.drawPath(path, blackStrokePaint)*/

        /*matrix0.reset()
        matrix0.setScale(2f, 1.5f, midWidth, midHeight)
        path.transform(matrix0)
        canvas.drawPath(path, blackStrokePaint)*/


/*

        canvas.save()
        canvas.translate(50f, 0f)
        canvas.drawPath(path, blackStrokePaint)
        canvas.translate(50f, 0f)
        canvas.drawPath(path, blackStrokePaint)
        canvas.translate(50f, 0f)
        canvas.save()
        canvas.drawPath(path, blackStrokePaint)
        canvas.translate(50f, 0f)
        canvas.drawPath(path, blackStrokePaint)
        canvas.restore()
        path.offset(0f, 150f)
        canvas.drawPath(path, blackStrokePaint)
*/

        //canvas.c

    }
}