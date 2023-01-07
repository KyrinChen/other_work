package State;

public class StateTired extends CatState {
    @Override
    public void feedCat() {
        super.stateContext.setCatState(new StateCommon());
    }

    @Override
    public void attendGame() {
    }

    @Override
    public double getState() {
        return 0.7;
    }

    @Override
    public String toString() {
        return "StateTired";
    }
}
