package Mediator;

public class ConcreteMediator extends Mediator {

    private ConcreteOthers Others;//具体同事1，其他猫猫
    private ConcreteCat cat;//具体同事2，运动员猫猫

    public void setOthers(ConcreteOthers Others) {
        this.Others = Others;
    }

    public void setCat(ConcreteCat Athlete) {
        this.cat = Athlete;
    }

    @Override
    //普通动物和运动员发送信息功能
    public void send(String message, Colleague colleague) {
        if (colleague == Others) {
            cat.notify(message);
        } else {
            Others.notify(message);
        }
    }
}
