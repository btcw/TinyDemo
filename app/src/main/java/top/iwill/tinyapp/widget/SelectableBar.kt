package top.iwill.tinyapp.widget

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import top.iwill.tinyapp.R

/**
 * Comment: //自定义底栏
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/27
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class SelectableBar(context: Context, attributeSet: AttributeSet)
    : CardView(context, attributeSet), View.OnClickListener {

    private var iconOn: ImageView
    private var textOn: TextView
    private var layoutOn: LinearLayout

    private var iconOff: ImageView
    private var textOff: TextView
    private var layoutOff: LinearLayout

    private var iconError: ImageView
    private var textError: TextView
    private var layoutError: LinearLayout

    var isSelectedOn = false
    var isSelectedOff = false
    var isSelectedError = false

    private var listener: ItemSelectListener? = null

    init {
        val cardView = LayoutInflater.from(context).inflate(R.layout.selectable_bar_layout, this)
        iconOn = cardView.findViewById(R.id.selectable_bar_icon_on)
        iconOff = cardView.findViewById(R.id.selectable_bar_icon_off)
        iconError = cardView.findViewById(R.id.selectable_bar_icon_error)

        textOn = cardView.findViewById(R.id.selectable_bar_text_on)
        textOff = cardView.findViewById(R.id.selectable_bar_text_off)
        textError = cardView.findViewById(R.id.selectable_bar_text_error)

        layoutOn = cardView.findViewById(R.id.selectable_bar_ll_on)
        layoutOff = cardView.findViewById(R.id.selectable_bar_ll_off)
        layoutError = cardView.findViewById(R.id.selectable_bar_ll_error)

        layoutOn.setOnClickListener(this)
        layoutOff.setOnClickListener(this)
        layoutError.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.selectable_bar_ll_on -> selectOn()
            R.id.selectable_bar_ll_off -> selectOff()
            R.id.selectable_bar_ll_error -> selectError()
        }
    }

    fun setOnItemSelectListener(listener: ItemSelectListener) {
        this.listener = listener
    }

    /**
     * 选择正常
     */
    private fun selectOn() {
        if (isSelectedOn) {
            iconOn.setImageResource(R.color.selectable_bar_not_selected)
            textOn.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_not_selected))
        } else {
            iconOn.setImageResource(R.color.selectable_bar_selected)
            textOn.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_selected))
        }
        isSelectedOn = !isSelectedOn
        listener?.onSelectedOn(isSelectedOn)
    }

    /**
     * 选择离线
     */
    private fun selectOff() {
        if (isSelectedOff) {
            iconOff.setImageResource(R.color.selectable_bar_not_selected)
            textOff.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_not_selected))
        } else {
            iconOff.setImageResource(R.color.selectable_bar_selected)
            textOff.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_selected))
        }
        isSelectedOff = !isSelectedOff
        listener?.onSelectedOff(isSelectedOff)
    }

    /**
     * 选择故障
     */
    private fun selectError() {
        if (isSelectedError) {
            iconError.setImageResource(R.color.selectable_bar_not_selected)
            textError.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_not_selected))
        } else {
            iconError.setImageResource(R.color.selectable_bar_selected)
            textError.setTextColor(ContextCompat.getColor(context, R.color.selectable_bar_selected))
        }
        isSelectedError = !isSelectedError
        listener?.onSelectedError(isSelectedError)
    }

    /**
     * 选项选择监听
     */
    interface ItemSelectListener {

        /**
         * 选择 “正常”按钮
         */
        fun onSelectedOn(isSelected: Boolean)

        /**
         * 选择 “离线”按钮
         */
        fun onSelectedOff(isSelected: Boolean)

        /**
         * 选择 “故障”按钮
         */
        fun onSelectedError(isSelected: Boolean)
    }


}