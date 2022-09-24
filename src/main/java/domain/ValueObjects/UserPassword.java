package domain.ValueObjects;

import javax.persistence.Embeddable;

@Embeddable
public class UserPassword {
    private final int MIN = 5;
    private final int MAX = 12;
    private String value;

    public UserPassword(String password) throws IllegalArgumentException {
        validate(password);
        this.value= password;
    }
    private void validate(String password) throws IllegalArgumentException {
        if(password.length()<MIN)
            throw new IllegalArgumentException("Password is to short");
        if(password.length()>MAX)
            throw new IllegalArgumentException("Password is to long");
    }
    public String value(){
        return this.value;
    }



}
