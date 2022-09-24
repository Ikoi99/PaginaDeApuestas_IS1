package domain.ValueObjects;


import javax.persistence.Embeddable;

@Embeddable
public class ForecastName extends StringValueObject {
    public ForecastName(String value) {
        super(value);
    }
}
