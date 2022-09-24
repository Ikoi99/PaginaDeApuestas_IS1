package domain.ValueObjects;


public class BetAmount extends FloatValueObject {

    protected BetAmount(float value) throws Exception {
        super(value);
        validate(value);
    }
    private void validate(float value) throws Exception {
        if(value < 1.0f)
            throw  new Exception("The bet amount is to small");
        if(value > 3.0f)
            throw new Exception("The bet amount is to big");
    }
}
