package Observer;

import Iterator.CatContainer;

public class CatObserve implements Observer {

    int CatNum;

    public CatObserve(int catNum) {
        CatNum = catNum;
    }

    //更新同步数据
    @Override
    public void update(int game, int rank, double score) {
        CatContainer.getInstance().get(CatNum).getRank()[game] = rank;
        CatContainer.getInstance().get(CatNum).getScore()[game] = score;
    }
}
