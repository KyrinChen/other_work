package Command_Memento;

import Decorator.CondimentDecorator;
import Decorator.Food;
import Decorator.Vitamin;

public class AddVitaminCommand implements Command {
    //添加配料维生素剂
    private Food myFood;
    private CondimentDecorator addVitamin;

    public AddVitaminCommand(Food myFood) {
        this.myFood = myFood;
    }

    public void execute() {
        addVitamin = new Vitamin(myFood);
        System.out.println("喂食:" + addVitamin.getDescription());
    }

    public Food getMyFood() {
        return myFood;
    }
}
