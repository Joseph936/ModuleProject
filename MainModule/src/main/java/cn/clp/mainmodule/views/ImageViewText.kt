package cn.clp.mainmodule.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import me.jessyan.autosize.utils.AutoSizeUtils


//class ImageViewText @JvmOverloads constructor(context: Context) : AppCompatImageView(context) {
//class ImageViewText(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
class ImageViewText @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var content: String? = null
    private var textSize: Int = AutoSizeUtils.dp2px(context, 12f)
    private var textColor: Int = Color.parseColor("#FFFFF6")

    init {
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mPaint?.color = textColor
        mPaint?.textSize = textSize.toFloat()
        mPaint?.style = Paint.Style.FILL
    }

    fun setTextColor(color: Int) {
        this.textColor = color
        drawableStateChanged()
    }

    fun setTextSize(textSize: Int) {
        this.textSize = textSize;
        drawableStateChanged()
    }

    fun setTextContent(content: String) {
        this.content = content
        drawableStateChanged()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //指定控件的宽高，需要测量

        //指定控件的宽高，需要测量
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthMode == MeasureSpec.AT_MOST) { //在布局中指定了wrap_content
            val bounds = Rect()
            content?.length?.let { mPaint?.getTextBounds(content, 0, it, bounds) }
            widthSize = bounds.width() + paddingLeft + paddingRight
        } else if (widthMode == MeasureSpec.EXACTLY) { //在布局中指定了确定的值 比如:100dp / match_parent
        } else if (widthMode == MeasureSpec.UNSPECIFIED) { //尽可能的大，很少能用到
            //ListView、ScrollView在测量子布局的时候会用
        }

        if (heightMode == MeasureSpec.AT_MOST) { //在布局中指定了wrap_content
            val bounds = Rect()
            content?.length?.let { mPaint?.getTextBounds(content, 0, it, bounds) }
            heightSize = bounds.height() + paddingTop + paddingBottom
        } else if (heightMode == MeasureSpec.EXACTLY) { //在布局中指定了确定的值  比如:100dp / match_parent
        } else if (heightMode == MeasureSpec.UNSPECIFIED) { //尽可能的大，很少能用到
            //ListView、ScrollView在测量子布局的时候会用
        }

        setMeasuredDimension(widthSize, heightSize)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        var fontMetrics = mPaint?.getFontMetrics()
//        var dy = (fontMetrics?.descent?.minus(fontMetrics?.ascent!!))?.div(2 - fontMetrics?.descent!!)
//        //得到基线（BaseLine）
//        var baseLine = getHeight() / 2 + dy!!
//        var x = getPaddingLeft()
//        content?.let { mPaint?.let { it1 -> canvas?.drawText(it, x.toFloat(), baseLine, it1) } }

        var height=height
        var width=width
        if (TextUtils.isEmpty(content)) return
        content?.let { mPaint?.let { it1 -> canvas?.drawText(it, 0f, height.toFloat(), it1) } }
    }
}