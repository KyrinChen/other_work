package Mediator;

public class ConcreteOthers extends Colleague {
    //具体同事类，观众猫猫

    public ConcreteOthers(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("其他猫猫通过中介得到消息：" + message);
    }

}