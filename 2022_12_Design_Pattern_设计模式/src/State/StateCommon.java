package State;

public class StateCommon extends CatState {
    @Override
    public void feedCat() {
        super.stateContext.setCatState(new StatePerfect());
    }

    @Override
    public void attendGame() {
        super.stateContext.setCatState(new StateTired());
    }

    @Override
    public double getState() {
        return 1.0;
    }

    @Override
    public String toString() {
        return "StateCommon";
    }
}
