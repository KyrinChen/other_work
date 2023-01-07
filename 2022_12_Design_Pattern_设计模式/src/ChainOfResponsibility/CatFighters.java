package ChainOfResponsibility;

import Iterator.CatContainer;

import java.util.ArrayList;
import java.util.Random;

public class CatFighters {

    private ArrayList<CatFighter> catFighters = new ArrayList<>();
    private CatFighter presentFighter;

    public CatFighters() {
        for (int i = 0; i < 8; ++i) {
            CatFighter catFighterFighter = new CatFighter();
            catFighterFighter.setCat(CatContainer.getInstance().get(i));
            catFighters.add(catFighterFighter);
        }
    }

    public void fight() {
        int i = 1;
        presentFighter = catFighters.get(0);
        presentFighter.setNextAbstractOpponent(catFighters.get(1));

        while (i < catFighters.size()) {
            CatFighter nextFighter = (CatFighter) presentFighter.getNextAbstractOpponent();
            Random rand1 = new Random();
            double random1 = (rand1.nextInt(2000) + 9000);
            Random rand2 = new Random();
            double random2 = (rand2.nextInt(2000) + 9000);
            double value1 = (presentFighter.getCat().getBeauty() * 10 + presentFighter.getCat().getIntelligence() * 11
                    + presentFighter.getCat().getSpeed() * 14 + presentFighter.getCat().getSkill() * 12)
                    * presentFighter.getCat().getCatState().getState() * random1;
            double value2 = (nextFighter.getCat().getBeauty() * 10 + nextFighter.getCat().getIntelligence() * 11
                    + nextFighter.getCat().getSpeed() * 14 + nextFighter.getCat().getSkill() * 12)
                    * nextFighter.getCat().getCatState().getState() * random2;
            if (value1 >= value2) {
                System.out.println("第" + i + "轮：" + presentFighter.getCat().getCatName()
                        + " vs " + nextFighter.getCat().getCatName() + "  胜者："
                        + presentFighter.getCat().getCatName());
                if (i == 7) break;
                presentFighter.setNextAbstractOpponent(catFighters.get(++i));
            } else {
                System.out.println("第" + i + "轮：" + presentFighter.getCat().getCatName()
                        + " vs " + nextFighter.getCat().getCatName() + "  胜者："
                        + nextFighter.getCat().getCatName());
                if (i == 7) break;
                presentFighter = (CatFighter) presentFighter.getNextAbstractOpponent();
                presentFighter.setNextAbstractOpponent(catFighters.get(++i));
            }
        }
        System.out.println("冠军是" + presentFighter.getCat().getCatName() + '!');
    }

}
