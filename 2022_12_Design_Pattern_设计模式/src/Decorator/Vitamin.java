package Decorator;

public class Vitamin extends CondimentDecorator {
    //维生素类（装饰者）
    public Vitamin(Food food) {
        super(food);
        getMyFood().condiment = getMyFood().condiment + "+维生素";
    }

    @Override
    public String getDescription() {
        return "维生素";
    }

}
