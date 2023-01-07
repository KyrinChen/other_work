package ChainOfResponsibility;

import SimpleFactory.Cat;

public class CatFighter extends AbstractOpponent  {
    private Cat cat;
    private CatFighter presentFighter;

    public CatFighter() {
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
