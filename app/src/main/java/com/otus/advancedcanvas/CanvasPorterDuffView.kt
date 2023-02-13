package com.otus.advancedcanvas

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import android.R.attr.mode
import android.graphics.PorterDuffXfermode
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Bitmap





class CanvasPorterDuffView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var pathSrc = Path()
    var pathDst = Path()
    val bitmapSrc : Bitmap
    val bitmapDst : Bitmap

    val paintSrc: Paint
    val paintDst: Paint
    val paintBorder: Paint

    val mode : PorterDuff.Mode = PorterDuff.Mode.SRC

    val colorDst : Int = Color.BLUE;
    val colorSrc : Int = Color.YELLOW

    init {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        pathDst = Path()
        pathDst.moveTo(0f, 0f)
        pathDst.lineTo(500f, 0f)
        pathDst.lineTo(500f, 500f)
        pathDst.close()

        bitmapDst = createBitmap(pathDst, colorDst)

        paintDst = Paint().apply {
            //color = colorDst
        }

        pathSrc = Path()
        pathSrc.moveTo(0f, 0f)
        pathSrc.lineTo(500f, 0f)
        pathSrc.lineTo(0f, 500f)
        pathSrc.close()

        bitmapSrc = createBitmap(pathSrc, colorSrc)

        paintSrc = Paint().apply {
            xfermode = PorterDuffXfermode(mode)
            //color = colorSrc
        }

        paintBorder = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = 3f
            color = Color.BLACK
        }
    }

    private fun createBitmap(path: Path, color: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
        val bitmapCanvas = Canvas(bitmap)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = color

        bitmapCanvas.drawPath(path, paint)

        return bitmap
    }
    override fun onDraw(canvas: Canvas?) {
        Log.d("CanvasBasicsView", "onDraw")
        if (canvas == null) return

        canvas.translate(390f, 80f);

        //canvas.drawPath(pathDst, paintDst)
        //canvas.drawPath(pathSrc, paintSrc)
        canvas.drawBitmap(bitmapDst, 0f, 0f, paintDst)
        canvas.drawBitmap(bitmapSrc, 0f, 0f, paintSrc)
        canvas.drawRect(0f, 0f, 500f, 500f, paintBorder)

    }
}