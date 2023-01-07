package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public class PerfectEquip implements EquipmentImplementor {
    //桥接
    @Override
    public void equip(Cat Cat, Equipment equipment) {
        System.out.println("装备：" + equipment.getEquipmentName() + "被完美地安装在了" + Cat.getCatName()
                + "身上！！");
    }
}
