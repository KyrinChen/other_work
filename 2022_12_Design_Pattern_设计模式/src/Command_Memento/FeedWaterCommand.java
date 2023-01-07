package Command_Memento;

import Decorator.Food;
import Decorator.Water;

public class FeedWaterCommand implements Command {
    //投喂饮用水命令
    private Water myMineralWater = new Water();

    @Override
    public void execute() {
        System.out.println("喂食:" + myMineralWater.getDescription());
    }

    @Override
    public Food getMyFood() {
        return myMineralWater;
    }

}
