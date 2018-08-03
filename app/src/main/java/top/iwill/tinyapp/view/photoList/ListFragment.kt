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

    lateinit var recyclerview: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pic_list_layout, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
        val bundle = arguments
        val photos = bundle?.getStringArrayList("photos")
        recyclerview.adapter = PhotoAdapter(photos ?: arrayListOf())
        recyclerview.layoutManager = LinearLayoutManager(activity)
        return view
    }

}