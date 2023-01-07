package Filter;

import SimpleFactory.Cat;

import java.util.ArrayList;

public class CompetitionLevelCriteria implements Criteria {
    //该标准判断对象颜色是否为赛级
    @Override
    public ArrayList<Cat> meetCriteria(ArrayList<Cat> catList) {
        ArrayList<Cat> greenCats = new ArrayList<>();

        for (Cat cat : catList) {
            if (cat.getCatAncestry().getAncestry() == "赛级") {
                greenCats.add(cat);
            }
        }
        return greenCats;
    }
}
