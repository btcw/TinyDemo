package top.iwill.tinyapp.view.photoList

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.View
import com.amap.api.maps.AMap
import kotlinx.android.synthetic.main.activity_photo_list_layout.*
import kotlinx.android.synthetic.main.custom_action_bar_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.utils.getWindowMetrics
import top.iwill.tinyapp.utils.locateOnce

/**
 * Comment: //图片列表界面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoListActivity : BaseActivity() {

    private lateinit var mAmap: AMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list_layout)
        deviceMap.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        actionbarTitle.text = "查看"
        mAmap = deviceMap.map
        mAmap.setPointToCenter(getWindowMetrics(this).heightPixels / 4, getWindowMetrics(this).widthPixels / 2)
        mAmap.locateOnce()
        val fragments = mutableListOf<Fragment>()
        fragments.add(ListFragment())
        fragments.add(ListFragment2())
        fragments.add(ListFragment())
        fragments.add(ListFragment2())
        fragments.add(ListFragment())
        photoViewPager.adapter = PhotoPagerAdapter(fragments, supportFragmentManager)
        photoViewPager.currentItem = 0
        photoViewPager.offscreenPageLimit = 2
    }

    override fun onResume() {
        super.onResume()
        deviceMap.onResume()
    }

    override fun onPause() {
        super.onPause()
        deviceMap.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        deviceMap.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        deviceMap.onSaveInstanceState(outState)
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.actionbarBack -> finish()
        }
    }


}
