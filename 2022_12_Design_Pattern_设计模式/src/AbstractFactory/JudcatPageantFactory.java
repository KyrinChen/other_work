package AbstractFactory;

public class JudcatPageantFactory implements JudgeIngredientFactory {
    // 吹罚选美
    @Override
    public Breed CreateBreed() {
        return new Judcat();
    }

    @Override

    public GameClass CreateClass() {

        return new CompPageant();
    }
}
