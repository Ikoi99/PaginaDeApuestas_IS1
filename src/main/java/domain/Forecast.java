package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import domain.ValueObjects.ForecastId;
import domain.ValueObjects.ForecastMultiplier;
import domain.ValueObjects.ForecastName;
import domain.ValueObjects.ForecastState;

@Entity
public class Forecast {
    @Id
    public final ForecastId id;
    @Embedded
    private ForecastName name;
    @Embedded
    private ForecastMultiplier multiplier;
    private Question question;
    private List<Bet> bets= new ArrayList<>();
    
    private ForecastState state;
    
    public Forecast(String name, float multiplier, Question question){
        this.id=new ForecastId();
        this.name=new ForecastName(name);
        this.multiplier=new ForecastMultiplier(multiplier);
        this.question=question;
        this.state=new ForecastState("INPROGRESS");
    }
    public void changeState(String state){
        this.state=new ForecastState(state);
    }

}
