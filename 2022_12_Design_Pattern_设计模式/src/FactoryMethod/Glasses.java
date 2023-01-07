package FactoryMethod;

import SimpleFactory.Cat;

public class Glasses extends Equipment {
    //博识眼镜
    @Override
    public void function() {
        System.out.println("获得博识眼镜");
        System.out.println("智力提升了");
    }

    public Glasses(Cat owner) {
        super(owner);
    }

    @Override
    public String getEquipmentName() {
        return "Glasses";
    }
}
