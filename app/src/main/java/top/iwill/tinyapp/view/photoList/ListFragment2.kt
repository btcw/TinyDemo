package top.iwill.tinyapp.view.photoList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import top.iwill.tinyapp.R

/**
 * Comment: //测试
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/20
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class ListFragment2 : Fragment() {

    private val img = ""

    lateinit var recyclerview: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pic_list_layout2, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
//        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerview.adapter = PhotoAdapter(arrayListOf(img,img,img,img,img,img,img,img))
//        recyclerview.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {

    }

    public fun setBackground(color: Int): Fragment {
        recyclerview.setImageResource(color)
        return this
    }


}