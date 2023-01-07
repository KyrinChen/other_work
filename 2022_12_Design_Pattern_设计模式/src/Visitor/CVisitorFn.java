package Visitor;

import Builder.Game;
import Iterator.CatContainer;

public class CVisitorFn {
    public static void VisitorFn(int cat, Game game) {
        Hall hall = new Hall();
        //添加模拟运动员排名信息
        int no = 0;
        switch (game.getName()) {
            case "竞速比赛":
                break;
            case "选美比赛":
                no = 1;
                break;
            case "智力比赛":
                no = 2;
                break;
            case "技术比赛":
                no = 3;
                break;
        }
        hall.addElement(new RankingList(game.getName(), CatContainer.getInstance().get(cat).getCatName(),
                CatContainer.getInstance().get(cat).getRank()[no]));

        RankingViewer audience = new Audience();
        //观众访问大厅
        hall.show(audience);

        ((Audience) audience).getCertainItem();
        ((Audience) audience).getCertainName();
        ((Audience) audience).getCertainRanking();


    }
}
