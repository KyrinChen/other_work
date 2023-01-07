package DAO;

import java.util.List;

public interface CatDao {
    List<Cat> getAllCat();

    Cat getCat(int rollNo);

    void updateCat(Cat cat);//更新运动员

    void deleteCat(Cat cat);//删除运动员
}
