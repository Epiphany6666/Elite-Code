package cn.elitecode.module.system.dal.dataobject.logger;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
* system_user_login_info(系统访问记录) | 实体类
* @TableName
*/
public class UserLoginInfoDO {

    @ApiModelProperty("ID，主键")
    private Long id;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("登录IP地址")
    private String ip;

    @ApiModelProperty("登陆地点")
    private String address;

    @ApiModelProperty("浏览器类型")
    private String browser;

    @ApiModelProperty("操作系统")
    private String os;

    @ApiModelProperty("登录状态 (0成功 1失败)")
    private String status;

    @ApiModelProperty("提示消息")
    private String msg;

    @ApiModelProperty("登录时间")
    private Date loginTime;

    public UserLoginInfoDO() {
    }

    public UserLoginInfoDO(Long id, String username, String ip, String address, String browser, String os, String status, String msg, Date loginTime) {
        this.id = id;
        this.username = username;
        this.ip = ip;
        this.address = address;
        this.browser = browser;
        this.os = os;
        this.status = status;
        this.msg = msg;
        this.loginTime = loginTime;
    }

    /**
    * ID，主键
    */
    public void setId(Long id){
    this.id = id;
    }

    /**
    * 用户账号
    */
    public void setUsername(String username){
    this.username = username;
    }

    /**
    * 登录IP地址
    */
    public void setIp(String ip){
    this.ip = ip;
    }

    /**
    * 登陆地点
    */
    public void setAddress(String address){
    this.address = address;
    }

    /**
    * 浏览器类型
    */
    public void setBrowser(String browser){
    this.browser = browser;
    }

    /**
    * 操作系统
    */
    public void setOs(String os){
    this.os = os;
    }

    /**
    * 登录状态 (0成功 1失败)
    */
    public void setStatus(String status){
    this.status = status;
    }

    /**
    * 提示消息
    */
    public void setMsg(String msg){
    this.msg = msg;
    }

    /**
    * 登录时间
    */
    public void setLoginTime(Date loginTime){
    this.loginTime = loginTime;
    }


    /**
    * ID，主键
    */
    public Long getId(){
    return this.id;
    }

    /**
    * 用户账号
    */
    public String getUsername(){
    return this.username;
    }

    /**
    * 登录IP地址
    */
    public String getIp(){
    return this.ip;
    }

    /**
    * 登陆地点
    */
    public String getAddress(){
    return this.address;
    }

    /**
    * 浏览器类型
    */
    public String getBrowser(){
    return this.browser;
    }

    /**
    * 操作系统
    */
    public String getOs(){
    return this.os;
    }

    /**
    * 登录状态 (0成功 1失败)
    */
    public String getStatus(){
    return this.status;
    }

    /**
    * 提示消息
    */
    public String getMsg(){
    return this.msg;
    }

    /**
    * 登录时间
    */
    public Date getLoginTime(){
    return this.loginTime;
    }

    public String toString() {
        return "UserLoginInfoDO{id = " + id + ", username = " + username + ", ip = " + ip + ", address = " + address + ", browser = " + browser + ", os = " + os + ", status = " + status + ", msg = " + msg + ", loginTime = " + loginTime + "}";
    }

}
