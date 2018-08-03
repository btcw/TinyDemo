package top.iwill.tinyapp.http.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Comment: //设备的图片返回
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class DevicePhotoResult {

    /**
     * type : 1
     * data : [{"id":"7","pic_name":"20180730172704725.jpeg"},{"id":"1","pic_name":"20180730172704725.jpeg"}]
     */

    private int type;
    @SerializedName("data")
    private List<Photo> photos;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
