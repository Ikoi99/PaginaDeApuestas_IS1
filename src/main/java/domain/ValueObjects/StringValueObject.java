package domain.ValueObjects;

import javax.persistence.Embeddable;

@Embeddable
public class StringValueObject {
    private String value;

    protected StringValueObject(String value)
    {
        this.value = value;
    }
    protected String value(){
        return value;
    }
}
