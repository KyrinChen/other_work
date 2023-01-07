package Prototpye_Flyweight;

import java.util.HashMap;
//  @program: AnimalGame
//  @description: 粉丝见面会
//  @author: zxa
//  @create: 2022/12/17

public class AttributeFactory {
    private static final HashMap<String, Audience> ChCountryCat_AudienceMap
            = new HashMap<>();

    private static final HashMap<String, Audience> Garfield_AudienceMap
            = new HashMap<>();
    private static final HashMap<String, Audience> Ragdoll_AudienceMap
            = new HashMap<>();

    //生成一个Dog
    public static Audience setChCountryCatAudience(String Ancestry) {
        Audience_ChCountryCat Audience_ChCountryCat = (Audience_ChCountryCat) ChCountryCat_AudienceMap.get(Ancestry);

        if (Audience_ChCountryCat == null) {
            Audience_ChCountryCat = new Audience_ChCountryCat(Ancestry);
            ChCountryCat_AudienceMap.put(Ancestry, Audience_ChCountryCat);
            System.out.println("这是第一只" + Ancestry + "中华田园猫");
        }
        return Audience_ChCountryCat;
    }

    //生成一个Cat
    public static Audience setGarfieldAudience(String Ancestry) {
        Audience_Garfield Audience_Garfield = (Audience_Garfield) Garfield_AudienceMap.get(Ancestry);

        if (Audience_Garfield == null) {
            Audience_Garfield = new Audience_Garfield(Ancestry);
            Garfield_AudienceMap.put(Ancestry, Audience_Garfield);
            System.out.println("这是第一只" + Ancestry + "加菲猫");
        }
        return Audience_Garfield;
    }

    //生成一个Bear
    public static Audience setRagdollAudience(String Ancestry) {
        Audience_Ragdoll Audience_Ragdoll = (Audience_Ragdoll) Ragdoll_AudienceMap.get(Ancestry);

        if (Audience_Ragdoll == null) {
            Audience_Ragdoll = new Audience_Ragdoll(Ancestry);
            Ragdoll_AudienceMap.put(Ancestry, Audience_Ragdoll);
            System.out.println("这是第一只" + Ancestry + "布偶猫");
        }
        return Audience_Ragdoll;
    }
}