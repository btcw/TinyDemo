package top.iwill.tinyapp.http.entity;

import java.util.List;

/**
 * Comment: //设备列表返回结果
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class DeviceListResult {

    /**
     * type : 1
     * data : [{"id":"1","deviceId":"db34a48b-0554-423b-8d24-3e3ac52196a3","longitude":"1","latitude":"1","name":"1","province":"1","city":"北京市","location":"11","run_status":"2"},{"id":"2","deviceId":"db34a48b-0554-423b-8d24-3e3ac52196a3","longitude":"1","latitude":"1","name":"1","province":"1","city":"北京市","location":"1","run_status":"2"}]
     */

    private Integer type;

    private List<DevicePoint> data;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<DevicePoint> getData() {
        return data;
    }

    public void setData(List<DevicePoint> data) {
        this.data = data;
    }
}
