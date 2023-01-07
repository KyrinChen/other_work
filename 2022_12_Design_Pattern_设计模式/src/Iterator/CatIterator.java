package Iterator;

import SimpleFactory.Cat;


public class CatIterator implements Iterator {
    //猫猫的迭代器类
    private CatContainer catContainer;
    private int index;

    // 将操作对象容器传入
    public CatIterator(CatContainer catContainer) {
        this.catContainer = catContainer;
        this.index = 0;
    }

    //判断是否有下一个对象存在
    @Override
    public boolean hasNext() {
        return index < catContainer.size();
    }

    //指针后移
    @Override
    public Object next() {
        Cat cat = catContainer.get(index);
        index++;
        return cat;
    }
}
