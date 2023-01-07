package State;

public class StateContext {
    private CatState catState;

    public void setCatState(CatState catState) {
        this.catState = catState;

        this.catState.setContext(this);
    }

    public double getState() {
        return this.catState.getState();
    }

}
