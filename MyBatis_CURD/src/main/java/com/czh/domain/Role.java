package com.czh.domain;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 14:50
 */
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleDesc;

    //多对多关系映射
    private List<User1> user1s;

    public List<User1> getUser1s() {
        return user1s;
    }

    public void setUser1s(List<User1> user1s) {
        this.user1s = user1s;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
