package cn.milkyship.backend.model.user;

import java.util.Date;

/*
 * <p>项目名称: backend </p>
 * <p>文件名称: SimpleUser </p>
 * <p>描述: 普通用户实体类 </p>
 * <p>创建时间: 2020-1-12 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯 FJH
 * @version v1.0
 */
public class SimpleUser extends User {
    private String userName;
    private String userSex;
    private String accountType;
    private Date userBirth;

    public SimpleUser() {
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }
}
