/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Role;
import entities.User;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class Role_DTO_IN {

    private String roleName;
    private List<User_DTO_IN> userList;

    public Role_DTO_IN() {
    }

    public Role_DTO_IN(Role role) {
        this.roleName = role.getRoleName();
        if (role.getUserList() != null) {
            for (User user : role.getUserList()) {
                this.userList.add(new User_DTO_IN(user));
            }
        }

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User_DTO_IN> getUserList() {
        return userList;
    }

    public void setUserList(List<User_DTO_IN> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role_DTO{" + "roleName=" + roleName + ", userList=" + userList + '}';
    }
    
    
}
