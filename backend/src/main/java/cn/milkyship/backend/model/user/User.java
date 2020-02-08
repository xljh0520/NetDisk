package cn.milkyship.backend.model.user;

/*
 * <p>项目名称: backend </p>
 * <p>文件名称: UserService </p>
 * <p>描述: 用户实体类的基类 </p>
 * <p>创建时间: 2020-1-12 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯 FJH
 * @version v1.0
 */
public abstract class User {
    private int id;
    private int profilePhoto;
    private int rootDir;

    public int getId() {
        return id;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public int getRootDir() {
        return rootDir;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public void setRootDir(int rootDir) {
        this.rootDir = rootDir;
    }
}
