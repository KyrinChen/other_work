package FactoryMethod;

import SimpleFactory.Cat;

public class Scarf extends Equipment {
    //讲究围巾
    @Override
    public void function() {
        System.out.println("获得讲究围巾");
        System.out.println("速度提升了");
    }

    public Scarf(Cat owner) {
        super(owner);
    }

    @Override
    public String getEquipmentName() {
        return "Scarf";
    }
}
