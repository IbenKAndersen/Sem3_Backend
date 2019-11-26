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
public class Role_DTO {

    private String roleName;
    private List<User_DTO> userList;

    public Role_DTO() {
    }

    public Role_DTO(Role role) {
        this.roleName = role.getRoleName();
        if (role.getUserList() != null) {
            for (User user : role.getUserList()) {
                this.userList.add(new User_DTO(user));
            }
        }

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User_DTO> getUserList() {
        return userList;
    }

    public void setUserList(List<User_DTO> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role_DTO{" + "roleName=" + roleName + ", userList=" + userList + '}';
    }
    
    
}
