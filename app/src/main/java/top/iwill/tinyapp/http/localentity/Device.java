package top.iwill.tinyapp.http.localentity;

import java.util.ArrayList;

/**
 * Comment: //网络解析实体转化来的本地实体
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class Device {

    private String id;

    private Double latitude;

    private Double longitude;

    private ArrayList<String> photos;

    public Device(String id, Double latitude, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Device(String id, Double latitude, Double longitude, ArrayList<String> photos) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }
}
