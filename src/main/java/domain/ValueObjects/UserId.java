package domain.ValueObjects;


import javax.persistence.Embeddable;

@Embeddable
public class UserId extends ValueObjectUUID {
    public UserId(){
        super();
    }
    public UserId(String id){
        super(id);
    }
}
