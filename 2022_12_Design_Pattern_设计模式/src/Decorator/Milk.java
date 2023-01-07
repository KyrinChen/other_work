package Decorator;

public class Milk extends CondimentDecorator {
    //牛奶类（装饰者）
    public Milk(Food food) {
        super(food);
        getMyFood().condiment = getMyFood().condiment + "+牛奶";
    }

    @Override
    public String getDescription() {
        return "牛奶";
    }

}
