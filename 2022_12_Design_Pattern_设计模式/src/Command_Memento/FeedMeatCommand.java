package Command_Memento;

import Decorator.Meat;
import Decorator.Food;

public class FeedMeatCommand implements Command {
    //投喂肉食的命令
    private Meat myMeat = new Meat();

    @Override
    public void execute() {
        System.out.println("喂食:" + myMeat.getDescription());
    }

    @Override
    public Food getMyFood() {
        return myMeat;
    }
}
