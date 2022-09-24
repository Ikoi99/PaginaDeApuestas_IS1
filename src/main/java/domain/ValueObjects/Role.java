package domain.ValueObjects;


import domain.Permission.Permission;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Role {
    private enum RoleEnum{
        USER("USER"),
        ADMIN("ADMIN");
        private String value;
        RoleEnum(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
    private RoleEnum role;
    private List<Permission> permissions= new ArrayList<Permission>();
    public Role(){
        this.role= RoleEnum.USER;
    }
    public Role(String role){
        if(role.equals("ADMIN")){
            this.role = RoleEnum.ADMIN;
            Permission getAllForecasts = new Permission("task::getForecasts::all");
            Permission createEvents = new Permission("task::createEvents::all");
            permissions.add(getAllForecasts);
            permissions.add(createEvents);
        }else{
            this.role = RoleEnum.USER;
        }
    }
    public static Role ChangeToAdmin(Role role){
        return new Role("ADMIN");
    }
    public boolean isAdmin(){
        return this.role == RoleEnum.ADMIN;
    }
    public String getUserType(){
        return this.role.getValue();
    }
    public List<Permission> getPermissions(){
        return permissions;
    }


}
