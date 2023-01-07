package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public class BadEquip implements EquipmentImplementor {
    //桥接
    @Override
    public void equip(Cat Cat, Equipment equipment) {
        System.out.println("装备：" + equipment.getEquipmentName() + "被糟糕的的安装在了" + Cat.getCatName()
                + "身上！！");
    }
}
