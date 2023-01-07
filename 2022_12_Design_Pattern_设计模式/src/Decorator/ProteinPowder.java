package Decorator;

public class ProteinPowder extends CondimentDecorator {
    //蛋白粉类（装饰者）
    public ProteinPowder(Food food) {
        super(food);
        getMyFood().condiment = getMyFood().condiment + "+蛋白粉";
    }

    @Override
    public String getDescription() {
        return "蛋白粉";
    }
}
