package domain.ValueObjects;

import javax.persistence.Embeddable;

@Embeddable
public class ForecastId extends ValueObjectUUID {
    public ForecastId(){
        super();
    }
    public ForecastId(String id){
        super(id);
    }
}
