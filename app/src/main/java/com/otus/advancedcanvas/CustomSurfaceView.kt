package com.otus.advancedcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class CustomSurfaceView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {

    lateinit var drawThread : DrawThread

    private fun init() {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawThread = DrawThread(getHolder())
        drawThread.setRunning(true)
        drawThread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        drawThread.setRunning(false)
    }

    class DrawThread(val holder : SurfaceHolder) : Thread() {
        var isRrunning = false

        fun setRunning(running : Boolean) {
            isRrunning = running
        }

        override fun run() {
            var canvas : Canvas?
            while (isRrunning) {
                canvas = holder.lockCanvas(null)
                canvas.drawColor(Color.GREEN)
                canvas.drawLine(0f, 0f, 100f, 100f, Paint().apply {
                    color = Color.BLACK
                    strokeWidth = 20f
                })
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }
}