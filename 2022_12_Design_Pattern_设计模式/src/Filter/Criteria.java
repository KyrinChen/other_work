package Filter;


import SimpleFactory.Cat;

import java.util.ArrayList;

public interface Criteria {
    //标准接口
    abstract ArrayList<Cat> meetCriteria(ArrayList<Cat> CatList);
}
