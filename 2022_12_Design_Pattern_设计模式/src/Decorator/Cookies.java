package Decorator;

public class Cookies extends Food {
    //饼干类（被装饰者）
    @Override
    public String getDescription() {
        return "饼干" + condiment;
    }
}
