package State;

public class StatePerfect extends CatState {
    @Override
    public void feedCat() {
    }

    @Override
    public void attendGame() {
        super.stateContext.setCatState(new StateCommon());
    }

    @Override
    public double getState() {
        return 1.1;
    }

    @Override
    public String toString() {
        return "StatePerfect";
    }
}
