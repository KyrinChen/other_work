package Iterator;

import SimpleFactory.Cat;
import java.util.ArrayList;

public class CatContainer implements Container {
    //猫猫容器

    //单例模式，使猫猫管理器可以被全局访问
    private static CatContainer instance = new CatContainer();
    //建立athlete容器
    private ArrayList<Cat> cats;

    private CatContainer() {
        cats = new ArrayList<>();
    }

    public static CatContainer getInstance() {
        return instance;
    }

    //根据指针返回容器对应的对象
    public Cat get(int index) {
        return cats.get(index);
    }

    //在容器末尾增加对象
    public void add(Cat cat) {
        cats.add(cat);
    }

    //返回容器大小
    public int size() {
        return cats.size();
    }

    //返回容器对象
    public ArrayList<Cat> getCats() {
        return cats;
    }

    //生成容器迭代器

    @Override
    public Iterator iterator() {
        return new CatIterator(this);
    }
}
