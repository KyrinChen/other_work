package Filter;

import SimpleFactory.Cat;
import SimpleFactory.CatFactory;

import java.util.ArrayList;

public class TestForCriteria {

    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        ArrayList<Cat> catList = new ArrayList<Cat>();
        catList.add(catFactory.createCat("加菲猫", "宠物级"));
        catList.add(catFactory.createCat("加菲猫", "赛级"));
        catList.add(catFactory.createCat("加菲猫", "血统级"));
        catList.add(catFactory.createCat("布偶猫", "宠物级"));
        catList.add(catFactory.createCat("布偶猫", "赛级"));
        catList.add(catFactory.createCat("中华田园猫", "宠物级"));
        catList.add(catFactory.createCat("中华田园猫", "血统级"));
        catList.add(catFactory.createCat("布偶猫", "血统级"));

        Criteria ragDollCriteria = new RagDollCatCriteria();
        Criteria competitionLevelCriteria = new CompetitionLevelCriteria();

        System.out.println("Before Filtering:");
        for (Cat cat : catList) {
            System.out.println(cat.getCatAncestry().getAncestry() + cat.getCatBreed().getBreed() + ":" + cat.getCatName());
        }
        AndCriteria andCriteria = new AndCriteria(ragDollCriteria, competitionLevelCriteria);
        ArrayList<Cat> filterList = andCriteria.meetCriteria(catList);

        System.out.println("After Filtering(CompetitionLevel RogDollCat):");
        for (Cat cat : filterList) {
            System.out.println(cat.getCatAncestry().getAncestry() + cat.getCatBreed().getBreed() + ":" + cat.getCatName());
        }
    }
}
