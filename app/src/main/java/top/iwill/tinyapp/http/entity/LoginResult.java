package top.iwill.tinyapp.http.entity;

/**
 * Comment: //登录结果
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class LoginResult {

    /**
     * name :
     * token : 28c8edde3d61a0411511d3b1866f0636
     */

    private String name;

    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
