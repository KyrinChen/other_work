package DAO;

public class DaoTest {
    public static void main(String[] args) {//dao模式测试
        CatDao catDao = new CatDaoImpl();

        //输出所有的运动员
        for (Cat cat : catDao.getAllCat()) {
            System.out.println("编号 : "
                    + cat.getRollNo() + ", 姓名 : " + cat.getName());
        }


        //更新运动员
        Cat cat = catDao.getAllCat().get(0);
        cat.setName("喵喵");
        catDao.updateCat(cat);

        //获取运动员
        catDao.getCat(0);
        System.out.println("编号 : "
                + cat.getRollNo() + ", 姓名 : " + cat.getName());
    }
}
