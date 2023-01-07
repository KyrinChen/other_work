package State;

public abstract class CatState {

    protected StateContext stateContext;

    public void setContext(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    public abstract void feedCat();

    public abstract void attendGame();

    public abstract double getState();
}
