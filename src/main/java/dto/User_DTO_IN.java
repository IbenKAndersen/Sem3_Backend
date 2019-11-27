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
public class User_DTO_IN {

    private String userName, userPass;
    private List<Role_DTO_IN> rolelist;

    public User_DTO_IN() {
    }

    public User_DTO_IN(User user) {
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        if (user.getRoleList() != null) {
            for (Role role : user.getRoleList()) {
                this.rolelist.add(new Role_DTO_IN(role));
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<Role_DTO_IN> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<Role_DTO_IN> rolelist) {
        this.rolelist = rolelist;
    }

    @Override
    public String toString() {
        return "User_DTO{" + "userName=" + userName + ", userPass=" + userPass + ", rolelist=" + rolelist + '}';
    }
    
    
}
