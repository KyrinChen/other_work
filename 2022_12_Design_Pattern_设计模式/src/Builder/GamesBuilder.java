package Builder;

import Iterator.GameContainer;
import Template_Strategy.RaceComp;
import Template_Strategy.QuizComp;
import Template_Strategy.PageantComp;
import Template_Strategy.HandcraftComp;

public class GamesBuilder {

    //单例模式
    private static GamesBuilder instance = new GamesBuilder();
    private GamesBuilder() { }
    public static GamesBuilder getInstance() {
        return instance;
    }

    //创建所有比赛
    public void buildGames() {
        GameContainer.getInstance().add(new RaceComp("竞速比赛"));
        GameContainer.getInstance().add(new PageantComp("选美比赛"));
        GameContainer.getInstance().add(new QuizComp("智力比赛"));
        GameContainer.getInstance().add(new HandcraftComp("技术比赛"));
    }
}
