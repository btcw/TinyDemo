package top.iwill.tinyapp.http.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Comment: //设备点实体
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class DevicePoint {


    /**
     * id : 1
     * deviceId : db34a48b-0554-423b-8d24-3e3ac52196a3
     * longitude : 1
     * latitude : 1
     * name : 1
     * province : 1
     * city : 北京市
     * location : 11
     * runStatus : 2
     */

    private Integer id;
    private String deviceId;
    private Double longitude;
    private Double latitude;
    private String name;
    private String province;
    private String city;
    private String location;
    @SerializedName("run_status")
    private Integer runStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }
}
