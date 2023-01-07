package Prototpye_Flyweight;

import java.util.Hashtable;
//  @program: AnimalGame
//  @description: 粉丝见面会
//  @author: zxa
//  @create: 2022/12/17


public class AudienceCache {
    private static Hashtable<String, Audience> audienceHashtable
            = new Hashtable<String, Audience>();

    //复制动物
    public static Audience getAudience(String audienceId) throws CloneNotSupportedException {
        Audience cachedAudience = audienceHashtable.get(audienceId);
        return (Audience) cachedAudience.clone();
    }

    //访问Cache
    public static void loadCache() {
        Audience_ChCountryCat chCountryCatAudience = new Audience_ChCountryCat();
        chCountryCatAudience.setId("1");
        chCountryCatAudience.setAge(4);
        audienceHashtable.put(chCountryCatAudience.getId(), chCountryCatAudience);

        Audience_Garfield garfieldAudience = new Audience_Garfield();
        garfieldAudience.setId("2");
        garfieldAudience.setAge(1);
        audienceHashtable.put(garfieldAudience.getId(), garfieldAudience);

        Audience_Ragdoll bearAudience = new Audience_Ragdoll();
        bearAudience.setId("3");
        bearAudience.setAge(2);
        audienceHashtable.put(bearAudience.getId(), bearAudience);
    }
}
