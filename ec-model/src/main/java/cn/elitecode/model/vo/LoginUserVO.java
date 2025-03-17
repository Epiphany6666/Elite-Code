package cn.elitecode.model.vo;

public class LoginUserVO {

    private String tokenHead;

    private String token;

    public LoginUserVO() {
    }

    public LoginUserVO(String tokenHead, String token) {
        this.tokenHead = tokenHead;
        this.token = token;
    }

    /**
     * 获取
     * @return tokenHeader
     */
    public String getTokenHead() {
        return tokenHead;
    }

    /**
     * 设置
     * @param tokenHead
     */
    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    /**
     * 获取
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
