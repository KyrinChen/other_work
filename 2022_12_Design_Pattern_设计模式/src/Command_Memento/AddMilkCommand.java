package Command_Memento;

import Decorator.CondimentDecorator;
import Decorator.Food;
import Decorator.Milk;

public class AddMilkCommand implements Command {
    //添加配料牛奶
    private Food myFood;

    private CondimentDecorator addMilk;

    public AddMilkCommand(Food myFood) {
        this.myFood = myFood;
    }

    public void execute() {
        addMilk = new Milk(myFood);
        System.out.println("喂食:" + addMilk.getDescription());
    }

    public Food getMyFood() {
        return myFood;
    }
}
