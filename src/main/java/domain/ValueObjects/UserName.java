package domain.ValueObjects;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserName {
    @Column(name = "userName")
    private String value;
    public UserName(String name)
    {
        this.value = name;
    }
    public String value(){
        return value;
    }
}
