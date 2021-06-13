package com.akexorcist.lovelyrecyclerview.view

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.akexorcist.lovelyrecyclerview.R

class TransparentProgressDialog(context: Context?, resourceIdOfImage: Int, textLoad: String?) : Dialog(context!!, R.style.TransparentProgressDialog) {
    private val iv: ImageView
    private val tv: TextView

    init {
        val windowManagerLayoutParam: WindowManager.LayoutParams = window!!.attributes.apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }
        window!!.attributes = windowManagerLayoutParam
        setTitle(null)
        setCancelable(false)
        setOnCancelListener(null)
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        iv = ImageView(context)
        tv = TextView(context)
        iv.setImageResource(resourceIdOfImage)
        tv.setTextColor(ContextCompat.getColor(context!!, R.color.little_light_gray))
        tv.textSize = 20f
        if (textLoad == null) {
            tv.text = getContext().getString(R.string.loading)
        } else {
            tv.text = textLoad
        }
        layout.addView(iv, params)
        layout.addView(tv, params)
        addContentView(layout, params)
    }

    override fun show() {
        super.show()
        val anim = RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f).apply {
            interpolator = LinearInterpolator()
            interpolator = LinearInterpolator()
            duration = 3000
        }
        iv.apply {
            animation = anim
            startAnimation(anim)
        }
    }

}