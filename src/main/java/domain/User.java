package domain;

import domain.Permission.Permission;
import domain.ValueObjects.Role;
import domain.ValueObjects.UserId;
import domain.ValueObjects.UserName;
import domain.ValueObjects.UserPassword;
import org.glassfish.ha.store.annotations.Attribute;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    private UserId id;
    @EmbeddedId
    private UserName name;
    @Embedded
    private UserPassword password;
    @Embedded
    private Role type;
    //date
    private int year;
    
    
    public User(String name, String password) throws IllegalArgumentException {
        this.id = new UserId();
        this.name = new UserName(name);
        this.password = new UserPassword(password);
        this.type = new Role();
    }
    public User(String id, String name, String password) throws IllegalArgumentException {
        this.id=new UserId(id);
        this.name=new UserName(name);
        this.password=new UserPassword(password);
        this.type= new Role();
    }
    public User(String role, String id, String name, String password) throws IllegalArgumentException {
        this.id=new UserId(id);
        this.name=new UserName(name);
        this.password=new UserPassword(password);
        this.type = new Role(role);
    }
    
    
    public User(String role, String id, String name, String password,int year) throws IllegalArgumentException {
        this.id=new UserId(id);
        this.name=new UserName(name);
        this.password=new UserPassword(password);
        this.type = new Role(role);
    }

    public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public UserPassword getPassword(){
        return password;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public void changePassword(UserPassword password) {
        this.password = password;
    }

    public void changeName(String name) {
        this.name = new UserName(name);
    }

    public void changeUserToAdmin() {
        this.type=Role.ChangeToAdmin(this.type);
    }
    public List<Permission> getPermissions(){
        return type.getPermissions();
    }
    public Boolean isAdmin() {
        return this.type.isAdmin();
    }


    
      
    @Override
    public String toString() {
        return "User{" +
                "name=" + name.value() +
                ", password=" + password.value() +
                ", type=" + type.getUserType() +
                '}';
    }
}