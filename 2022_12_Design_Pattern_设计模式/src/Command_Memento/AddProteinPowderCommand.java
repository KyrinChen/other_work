package Command_Memento;

import Decorator.CondimentDecorator;
import Decorator.Food;
import Decorator.ProteinPowder;

public class AddProteinPowderCommand implements Command {
    //添加配料蛋白粉
    private Food myFood;
    private CondimentDecorator addProteinPowder;

    public AddProteinPowderCommand(Food myFood) {
        this.myFood = myFood;
    }

    public void execute() {
        addProteinPowder = new ProteinPowder(myFood);
        System.out.println("喂食:" + addProteinPowder.getDescription());
    }

    public Food getMyFood() {
        return myFood;
    }
}
