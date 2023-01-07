package Mediator;

public class ConcreteCat extends Colleague {
    //具体同事类，运动员

    public ConcreteCat(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println(message);
    }

}

