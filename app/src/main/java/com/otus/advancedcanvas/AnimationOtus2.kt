package com.otus.advancedcanvas

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.core.animation.doOnStart

class AnimationOtus2
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    val size = 200
    var rotate = 0f
    var scal = 1f

    override fun onDraw(canvas: Canvas) {
        val midHeight = height / 2f
        val midWidth = width / 2f
        canvas.rotate(rotate, midWidth, midHeight)
        canvas.scale(scal,scal,midWidth, midHeight)
        canvas.drawRect(midWidth - size / 2f, midHeight - size / 2f, midWidth + size / 2f, midHeight + size / 2f, paint)
    }

    fun startAnim() {
        // 0 ->100
        // 1 ,2 ,3 ,4... 100
        // accelerate
        // 1, 2 ,3 ,4 , 6, 8, 12, 16, 20 , 30, 50, 64
        //bounce
        // 1, 2, 3, 100, 90, 95, 92
        // overshout
        // 1,2,3,120,110,100

/*
        ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            interpolator = BounceInterpolator()
            addUpdateListener {
                rotate = it.animatedValue as Float
                invalidate()
            }
            start()
        }
*/
        val rotateName = "rotateValue"
        val rotatePH = PropertyValuesHolder.ofFloat(rotateName,0f, 360f)
        val scaleName = "scaleValue"
        val scalePH = PropertyValuesHolder.ofFloat(scaleName, 1f, 2f)
        ValueAnimator.ofPropertyValuesHolder(rotatePH, scalePH).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            interpolator = BounceInterpolator()
            addUpdateListener {
                rotate = it.getAnimatedValue(rotateName) as Float
                scal = it.getAnimatedValue(scaleName) as Float
                invalidate()
            }
            start()

        }

    }
}