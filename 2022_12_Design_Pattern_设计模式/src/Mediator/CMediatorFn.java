package Mediator;

public class CMediatorFn {
    //单例模式
    private static CMediatorFn instance = new CMediatorFn();

    private CMediatorFn() {
    }

    public static CMediatorFn getInstance() {
        return instance;
    }

    public void MediateFn() {


        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteOthers Others = new ConcreteOthers(mediator);
        ConcreteCat Athlete = new ConcreteCat(mediator);

        mediator.setOthers(Others);
        mediator.setCat(Athlete);

        Others.send("在猫猫喂食区偶遇其他猫咪选手，通知了你尽快参加比赛。");
    }

}
