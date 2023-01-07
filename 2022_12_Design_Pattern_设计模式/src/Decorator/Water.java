package Decorator;

public class Water extends Food {
    //饮用水类（被装饰者）
    @Override
    public String getDescription() {
        return "饮用水" + condiment;
    }
}
