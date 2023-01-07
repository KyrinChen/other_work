package Decorator;

public class CondimentDecorator extends Food {
    //装饰者类（添加投喂配料）

    private Food myFood;

    public CondimentDecorator(Food myFood) {
        this.myFood = myFood;
    }

    public Food getMyFood() {
        return myFood;
    }

    public String getDescription() {
        return "null";
    }

}
