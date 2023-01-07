package AbstractFactory;

public class JudcatRaceFactory implements JudgeIngredientFactory {
    // 吹罚赛跑
    @Override

    public Breed CreateBreed() {

        return new Judcat();
    }

    @Override

    public GameClass CreateClass() {

        return new CompRace();
    }
}
