package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public interface EquipmentImplementor {
    public void equip(Cat animal, Equipment equipment);
}
