package domain;

import javax.persistence.Entity;

import domain.ValueObjects.BetAmount;
import domain.ValueObjects.BetId;
import domain.ValueObjects.BetState;

@Entity
public class Bet {
    public final BetId id;
    public final Forecast forecast;
    public final User user;
    public final BetAmount amount;
    private BetState state;
    public Bet(Forecast forecast, User user, BetAmount amount){
        this.id = new BetId();
        this.forecast=forecast;
        this.user=user;
        this.amount=amount;
        this.state=new BetState("AWAITING");
    }
    public void changeState(String state){
        this.state= new BetState(state);
    }

}
