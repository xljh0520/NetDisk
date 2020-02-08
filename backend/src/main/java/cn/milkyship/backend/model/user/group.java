package cn.milkyship.backend.model.user;

/*
 * <p>项目名称: backend </p>
 * <p>文件名称: group </p>
 * <p>描述: 群组实体类 </p>
 * <p>创建时间: 2020-1-12 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯 FJH
 * @version v1.0
 */
public class group extends User {
    private int numMembers;
    private int numFiles;
    private String groupName;

    public group() {
    }

    public int getNumMembers() {
        return numMembers;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setNumMembers(int numMembers) {
        this.numMembers = numMembers;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
