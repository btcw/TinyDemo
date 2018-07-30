package top.iwill.tinyapp.view.photoList

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import top.iwill.tinyapp.R
import top.iwill.tinyapp.widget.GlideApp

/**
 * Comment: //todo
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoAdapter(private val photos: List<String>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_photo_layout, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideApp.with(context)
                .load(photos[position])
                .centerCrop()
                .placeholder(R.color.yellow)
                .into(holder.photoImg)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoImg = view.findViewById<ImageView>(R.id.photoImage)!!
    }

}