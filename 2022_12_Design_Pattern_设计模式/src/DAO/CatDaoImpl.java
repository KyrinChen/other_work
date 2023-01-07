package DAO;

import java.util.ArrayList;
import java.util.List;

public class CatDaoImpl implements CatDao {

    //列表是当作一个数据库
    List<Cat> cats;

    //添加兔子和熊猫
    public CatDaoImpl() {
        cats = new ArrayList<Cat>();
        Cat cat1 = new Cat("魔幻假面喵", 0);
        Cat cat2 = new Cat("土地云也是土猫", 1);
        cats.add(cat1);
        cats.add(cat2);
    }

    //删除
    @Override
    public void deleteCat(Cat cat) {
        cats.remove(cat.getRollNo());
        System.out.println("编号 " + cat.getRollNo()
                + ", 数据库已删除");
    }

    //从数据库中检索运动员名单
    @Override
    public List<Cat> getAllCat() {
        return cats;
    }

    @Override
    public Cat getCat(int rollNo) {
        return cats.get(rollNo);
    }

    @Override
    public void updateCat(Cat cat) {
        cats.get(cat.getRollNo()).setName(cat.getName());
        System.out.println("编号 " + cat.getRollNo()
                + ", 数据库已更新");
    }
}