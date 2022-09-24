package domain.ValueObjects;

import javax.persistence.Embeddable;
import java.util.UUID;
@Embeddable
public class ValueObjectUUID {
    protected String value;

    public String getValue() {
        return value;
    }
    public ValueObjectUUID(){
        this.value = UUID.randomUUID().toString();
    }
    public ValueObjectUUID(String value){
        validate(value);
        this.value = value;
    }
    public void validate(String id){
        try{
            UUID uuid = UUID.fromString(id);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
