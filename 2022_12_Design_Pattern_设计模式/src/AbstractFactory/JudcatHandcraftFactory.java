package AbstractFactory;

public class JudcatHandcraftFactory implements JudgeIngredientFactory {
    // 吹罚技术比赛
    @Override

    public Breed CreateBreed() {

        return new Judcat();
    }

    @Override

    public  GameClass CreateClass() {

        return new CompHandcraft();
    }
}
