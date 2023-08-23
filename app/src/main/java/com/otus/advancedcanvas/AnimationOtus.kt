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
import androidx.core.animation.addListener

class AnimationOtus
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


/*
        paint.pathEffect = DiscretePathEffect(segmentLength, deviation)
        canvas.rotate(rotate, midWidth, midHeight)
        canvas.scale(scale, scale, midWidth, midHeight)
*/


        canvas.scale(scal, scal, midWidth, midHeight)
        canvas.rotate(rotate, midWidth, midHeight)

        canvas.drawRect(midWidth - size / 2f, midHeight - size / 2f, midWidth + size / 2f, midHeight + size / 2f, paint)
    }

    fun startAnim() {
        // 0 - 100
        // 2 sec
        // linear
        // 0 1 2 3 4 5 6 ... 100
        // accelerate
        // 0 5 10 20 45 55 60 62...100



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
        /*
                val rotateName = "rotateName"
                val scaleName = "scaleName"
                val deviationName = "deviationName"
                val rotatePH = PropertyValuesHolder.ofFloat(rotateName, 0f, 360f)
                val scalePH = PropertyValuesHolder.ofFloat(scaleName, 1f, 3f)
                val deviationPH = PropertyValuesHolder.ofFloat(deviationName, 0f, 25f)
                ValueAnimator.ofPropertyValuesHolder(rotatePH, scalePH, deviationPH).apply {
                    duration = 3000
                    repeatMode = ValueAnimator.REVERSE
                    repeatCount = ValueAnimator.INFINITE
                    interpolator = BounceInterpolator()
                    addUpdateListener {
                        rotate = it.getAnimatedValue(rotateName) as Float
                        scale = it.getAnimatedValue(scaleName) as Float
                        deviation = it.getAnimatedValue(deviationName) as Float
                        invalidate()
                    }
                    start()
                }
        */



        val scalePVHName = "scalePVHName"
        val scalePVH = PropertyValuesHolder.ofFloat(scalePVHName, 1f, 2f)

        val rotatePVHName = "rotatePVHName"
        val rotatePVH = PropertyValuesHolder.ofFloat(rotatePVHName, 0f, 360f)
        ValueAnimator.ofPropertyValuesHolder(scalePVH, rotatePVH).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            interpolator = BounceInterpolator()
            addUpdateListener {
                rotate = it.getAnimatedValue(rotatePVHName) as Float
                scal = it.getAnimatedValue(scalePVHName) as Float
                invalidate()
            }
            addListener(onStart = {
            })
            start()
        }
    }
}