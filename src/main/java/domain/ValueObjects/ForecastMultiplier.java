package domain.ValueObjects;


import javax.persistence.Embeddable;

@Embeddable
public class ForecastMultiplier extends FloatValueObject {
    public ForecastMultiplier(float value) {
        super(value);
    }
}
