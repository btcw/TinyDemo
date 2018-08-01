package top.iwill.tinyapp.view.photoList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.iwill.tinyapp.R

/**
 * Comment: //图片列表fragment
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/20
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class ListFragment : Fragment() {

    private val img = "https://iwill-top-1256873136.file.myqcloud.com/wp-content/pics/2018/07/p2.jpg"

    lateinit var recyclerview: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pic_list_layout, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        recyclerview.adapter = PhotoAdapter(arrayListOf(img,img,img,img,img,img,img,img))
        recyclerview.layoutManager = LinearLayoutManager(activity)
    }



}