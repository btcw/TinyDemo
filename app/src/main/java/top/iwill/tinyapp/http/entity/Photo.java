package top.iwill.tinyapp.http.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Comment: //照片
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class Photo {
    /**
     * id : 7
     * pic_name : 20180730172704725.jpeg
     */

    private String id;
    @SerializedName("pic_name")
    private String picName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
