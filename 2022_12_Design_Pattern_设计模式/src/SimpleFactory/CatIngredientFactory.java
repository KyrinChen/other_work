package SimpleFactory;

public class CatIngredientFactory {
    public Breed setBreed(String breed) {
        if (breed == null) {
            return null;
        }
        if (breed.equalsIgnoreCase("中华田园猫")) {
            return new ChineseRuralCat();
        } else if (breed.equalsIgnoreCase("布偶猫")) {
            return new RagdollCat();
        } else if (breed.equalsIgnoreCase("加菲猫")) {
            return new GarfieldCat();
        }
        return null;
    }

    //设置颜色
    public Ancestry setAncestry(String ancestry) {
        if (ancestry == null) {
            return null;
        }
        if (ancestry.equalsIgnoreCase("宠物级")) {
            return new PetLevel();
        } else if (ancestry.equalsIgnoreCase("血统级")) {
            return new BloodlineLevel();
        } else if (ancestry.equalsIgnoreCase("赛级")) {
            return new CompetitionLevel();
        }
        return null;
    }
}
