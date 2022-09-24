package domain.ValueObjects;


public class BetState {
    public enum State{
        AWAITING,
        WINNER,
        LOSER,
        CANCELLED
    }
    private State state;
    public BetState(String state){
        if("AWAITING".equalsIgnoreCase(state))
            this.state=State.AWAITING;
        if("WINNER".equalsIgnoreCase(state))
            this.state=State.AWAITING;
        if("LOSER".equalsIgnoreCase(state))
            this.state=State.AWAITING;
        if("CANCELLED".equalsIgnoreCase(state))
            this.state=State.AWAITING;
    }
    public String value(){
        return state.name();
    }

}
