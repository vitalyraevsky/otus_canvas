package com.otus.advancedcanvas

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import android.graphics.DashPathEffect



class CanvasPathView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    val blackPaint : Paint
    val blackStrokePaint : Paint
    val dotPaint : Paint

    val rec = RectF()
    val path = Path()
    val path1 = Path()
    val point = Point()
    val point1 = Point()

    init {
        blackPaint = Paint().apply {
            color = Color.RED
            strokeWidth = 3f
            textSize = 45f
            textAlign = Paint.Align.CENTER
            pathEffect = DiscretePathEffect(5f, 2f)
        }

        blackStrokePaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 6f
            style = Paint.Style.STROKE
            pathEffect = DiscretePathEffect(25f, 25f)
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

        canvas.drawRGB(129, 255, 120)


        path.reset()
        point.x = (midWidth - 100).toInt()
        point.y = 0.toInt()
        point1.x = (midWidth + 100).toInt()
        point1.y = height
        path.reset()

        path.moveTo(0f, 0f)
        path.cubicTo(point.x.toFloat(), point.y.toFloat(), point1.x.toFloat(), point1.y.toFloat(), width.toFloat(), height.toFloat())

        canvas.drawPath(path, blackStrokePaint)

        canvas.drawCircle(point.x.toFloat(), point.y.toFloat(), 20f, blackStrokePaint)
        canvas.drawCircle(point1.x.toFloat(), point1.y.toFloat(), 20f, blackStrokePaint)


        canvas.drawTextOnPath("Feel the pain", path, 0f, 50f,blackPaint)

/*
        point.x = (midWidth - 100).toInt()
        point.y = 0.toInt()
        point1.x = (midWidth + 100).toInt()
        point1.y = height
        path.reset()

        path.moveTo(0f, 0f)
        path.cubicTo(point.x.toFloat(), point.y.toFloat(), point1.x.toFloat(), point1.y.toFloat(), width.toFloat(), height.toFloat())

        blackStrokePaint.pathEffect = DashPathEffect(floatArrayOf(25f, 10f, 25f, 10f), 25f)
        canvas.drawPath(path, blackStrokePaint)

        canvas.drawCircle(point.x.toFloat(), point.y.toFloat(), 20f, blackStrokePaint)
        canvas.drawCircle(point1.x.toFloat(), point1.y.toFloat(), 20f, blackStrokePaint)
*/


/*
        path.moveTo(midWidth, midHeight)
        path.lineTo(midWidth, midHeight + 100)
        path.moveTo(midWidth+10f, midHeight)
        path.lineTo(midWidth+10f, midHeight + 100)

        canvas.drawPath(path, blackStrokePaint)*/
        /*
                path.reset()
                path.moveTo(midWidth, midHeight)
                path.lineTo(midWidth, midHeight + 100)
                path.lineTo(midWidth + 100, midHeight + 100)
                path.close()

                canvas.drawPath(path, blackStrokePaint)


                path1.moveTo(midWidth, midHeight)
                path1.addOval(rec, Path.Direction.CW)
                path1.addRect(rec, Path.Direction.CW)

                blackStrokePaint.color = Color.RED
                canvas.drawPath(path1, blackStrokePaint)


                path.addPath(path1)
                path.offset(20f, 20f)
                blackStrokePaint.color = Color.BLUE
                canvas.drawPath(path, blackStrokePaint)
        */

        /*
        path.reset()
        path.moveTo(midWidth, midHeight)
        path.lineTo(midWidth, midHeight + 100)
        path.lineTo(midWidth + 100, midHeight + 100)

        canvas.drawPath(path, blackStrokePaint)


        path1.moveTo(midWidth, midHeight)
        path1.addOval(rec, Path.Direction.CW)
        path1.addRect(rec, Path.Direction.CW)

        blackStrokePaint.color = Color.RED
        canvas.drawPath(path1, blackStrokePaint)

        path.addPath(path1)
        path.offset(20f, 20f)
        blackStrokePaint.color = Color.BLUE
        canvas.drawPath(path, blackStrokePaint)*/

        /*path.reset()
        point.x = (midWidth / 2).toInt()
        point.y = 0

        path.quadTo(point.x.toFloat(), point.y.toFloat(), midWidth, midHeight)
        canvas.drawPath(path, blackStrokePaint)

        canvas.drawCircle(point.x.toFloat(), point.y.toFloat(), 20f, blackStrokePaint)*/


        /*
        point.x = (midWidth - 100).toInt()
        point.y = 0.toInt()
        point1.x = (midWidth + 100).toInt()
        point1.y = height
        path.reset()

        path.moveTo(0f, 0f)
        path.cubicTo(point.x.toFloat(), point.y.toFloat(), point1.x.toFloat(), point1.y.toFloat(), width.toFloat(), height.toFloat())

        canvas.drawPath(path, blackStrokePaint)

        canvas.drawCircle(point.x.toFloat(), point.y.toFloat(), 20f, blackStrokePaint)
        canvas.drawCircle(point1.x.toFloat(), point1.y.toFloat(), 20f, blackStrokePaint)*/

        //blackStrokePaint.pathEffect = DashPathEffect(floatArrayOf(50f, 10f, 5f, 10f), 25f)


    }
}