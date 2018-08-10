package top.iwill.tinyapp.http.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Comment: //上一个设备和下一个设备
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class NextDeviceResult {

    /**
     * data : [{"id":"1","pic_name":"20180730172704725.jpeg","ctime":"1532942824"}]
     * location : {"longitude":"104.9579300000","latitude":"31.6846900000"}
     * deviceId : db34a48b-0554-423b-8d24-3e3ac52196a2
     */

    private LocationBean location;
    private String deviceId;
    @SerializedName("data")
    private List<DataBean> photos;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<DataBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<DataBean> photos) {
        this.photos = photos;
    }


    public static class LocationBean {
        /**
         * longitude : 104.9579300000
         * latitude : 31.6846900000
         */

        private Double longitude;
        private Double latitude;

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * pic_name : 20180730172704725.jpeg
         * ctime : 1532942824
         */

        private String id;
        private String pic_name;
        private String ctime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPic_name() {
            return pic_name;
        }

        public void setPic_name(String pic_name) {
            this.pic_name = pic_name;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }
    }
}
