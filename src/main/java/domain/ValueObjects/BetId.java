package domain.ValueObjects;


public class BetId extends ValueObjectUUID {
    public BetId(){
        super();
    }
    public BetId(String id){
        super(id);
    }
}
