package Command_Memento;

import Decorator.Cookies;
import Decorator.Food;

public class FeedCookiesCommand implements Command {
    //投喂饼干的命令
    private Cookies myCookies = new Cookies();

    @Override
    public void execute() {
        System.out.println("喂食:" + myCookies.getDescription());
    }

    @Override
    public Food getMyFood() {
        return myCookies;
    }
}
