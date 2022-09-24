package domain.ValueObjects;


import javax.persistence.Embeddable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class ForecastState {
    private enum State{
        CLOSED,
        INPROGRESS,
    }
    private State value;
    public ForecastState(String value){
        if("CLOSED".equalsIgnoreCase(value))
            this.value= State.CLOSED;
        if("INPROGRESS".equalsIgnoreCase(value))
            this.value= State.INPROGRESS;
    }
    public String value(){
        return value.name();
    }
}
