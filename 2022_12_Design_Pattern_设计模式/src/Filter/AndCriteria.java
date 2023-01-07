package Filter;

import SimpleFactory.Cat;

import java.util.ArrayList;

public class AndCriteria {
    //和标准类（用于筛选满足两个标准的对象）
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    //首先按第一个标准筛选第一次，该结果再经过第二次筛选得到最终筛选结果
    public ArrayList<Cat> meetCriteria(ArrayList<Cat> Cats) {
        ArrayList<Cat> firstCriteriaCats = criteria.meetCriteria(Cats);
        return otherCriteria.meetCriteria(firstCriteriaCats);
    }
}
