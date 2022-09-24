package domain.ValueObjects;

import javax.persistence.Embeddable;

@Embeddable
public class FloatValueObject {
    private float value;
    protected FloatValueObject(float value){
        this.value=value;
    }
    public float value(){
        return this.value;
    }
}
