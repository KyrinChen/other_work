package Filter;

import SimpleFactory.Cat;

import java.util.ArrayList;

public class RagDollCatCriteria implements Criteria {
    //该标准判断对象类型是否为布偶猫
    @Override
    public ArrayList<Cat> meetCriteria(ArrayList<Cat> CatList) {
        ArrayList<Cat> ragDollCat = new ArrayList<>();
        for (Cat cat : CatList) {
            if (cat.getCatBreed().getBreed() == "布偶猫") {
                ragDollCat.add(cat);
            }
        }
        return ragDollCat;
    }
}
