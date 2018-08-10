package top.iwill.tinyapp.view.photoList

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


/**
 * Comment: //图片viewpager的适配器
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/20
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoPagerAdapter(private val fragments: List<Fragment>
                        , fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getItemPosition(`object`: Any): Int = FragmentStatePagerAdapter.POSITION_NONE

}