2054305 陈敬麒

## 前端：

前端使用原生HTML和jQuery框架构建而成，其中实时聊天使用goEasy组件进行实现。

其中，index.html为登陆页面，main.html为主要聊天室页面，使用时要先进入index.html，登录后聊天室才能正常显示。展示如下：(注意，必须启动后端之后才可以正常体验前端的功能)

### 注册页面：

​                               ![image-20221227204340855](https://s2.loli.net/2022/12/27/SalwNBgcMAWxkfT.png)

### 登录页面：

 ![image-20221227204348671](https://s2.loli.net/2022/12/27/XW9eoa2cYzTQJnp.png)

### 登陆后页面：

 ![image-20221227204359135](https://s2.loli.net/2022/12/27/8fv3BWPO6TJognm.png)

左侧上边栏四个按钮，分别是添加好友，好友列表，群聊列表和个人中心。

### 添加好友：

 ![image-20221227204402787](https://s2.loli.net/2022/12/27/f7oKkLzI3rEXRgy.png)

### 群聊列表：

 ![image-20221227204422538](https://s2.loli.net/2022/12/27/OjfnzTuSyDgLp6E.png)

### 个人中心：

 ![image-20221227204427283](https://s2.loli.net/2022/12/27/zU45Fjc6iCBJKk1.png)

各个按钮均可使用，包括搜索好友并添加，更改个人信息。

点击好友列表和群聊列表能使得右边显示出对话列表，并且调用相应的历史信息：

### 好友聊天界面：

 ![image-20221227204432869](https://s2.loli.net/2022/12/27/hmljPBbYunoyZHS.png)

### 群聊聊天页面：

 ![image-20221227204446803](https://s2.loli.net/2022/12/27/EwSzmOuDGkeTKqA.png)

### 发送信息时，页面会对应刷新：

 ![image-20221227204439840](https://s2.loli.net/2022/12/27/3SjFf2MV5K6bdta.png)

 ![image-20221227204458954](https://s2.loli.net/2022/12/27/82zPgkHb5Ttj7rX.png)

### 支持删除好友和群组

 ![image-20221227204508482](https://s2.loli.net/2022/12/27/Gox4iwmYCW9ryFL.png) 

# 后端：

后端使用Java的springboot框架，考虑到数据量不大，使用MySQL数据库，其中使用了mybatis持久性框架，动态进行SQL语句进行数据调

### Controller包

所有用户使用的api均在此，共有16个

 ![image-20221227205710314](https://s2.loli.net/2022/12/27/wEieMRPvSgz5LBb.png)

### Entity包

所有数据库表的实体类:

 ![image-20221227204600537](https://s2.loli.net/2022/12/27/xmFwMCs4LTZIvok.png)

### Mapper包

实现后端与数据库的交互：

```java
import com.example.webtalk.entity.Gmessage;
import com.example.webtalk.entity.Group;
import com.example.webtalk.entity.Umessage;
import com.example.webtalk.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select friend_id from friend where user_id=#{userID}")
    List<Integer> getFriend(@Param("userID") Integer userID);

    @Select("select * from user where user_id=#{userID}")
    User getUser(@Param("userID") Integer userID);


    @Insert("insert into user(nick_name,sex,avatar,password,area,email) values(#{nickName},#{sex},#{avatar},#{password},#{area},#{email})")
    Integer addUser(@Param("nickName") String nickName,@Param("sex") String sex,
                    @Param("avatar") String avatar,@Param("password") String password,@Param("area") String area,
                    @Param("email") String email);

    @Select("select * from user where user_id=#{userID}")
    User login(@Param("userID") Integer userID);

    @Insert("insert into user(nick_name,sex,avatar,password,area,email) " +
            "values (#{user.nick_name}," +
            "#{user.sex},"+
            "#{user.avatar},"+
            "#{user.password},"+
            "#{user.area},"+
            "#{user.email})")
    @Options(useGeneratedKeys = true,keyProperty = "user.user_id")
    Integer register(@Param("user") User user);

    @Select("select group_id from take where user_id=#{userID}")
    List<Integer> getGroup(@Param("userID") int userID);

    @Select("select * from `group` where group_id = ${groupID}")
    Group getGroupInformation(@Param("groupID") int groupID);

    @Insert("insert into umessage(msg_content,msg_from,msg_to)  " +
            "values(#{message.msg_content}," +
            "#{message.msg_from}," +
            "#{message.msg_to}" +
            ")")
    Integer sendUMessage(@Param("message") Umessage message);

    @Insert("insert into gmessage(gmsg_content,gmsg_from,gmsg_to) " +
            "values(#{gmessage.gmsg_content}," +
            "#{gmessage.gmsg_from}," +
            "#{gmessage.gmsg_to}" +
            ")")
    Integer sendGMessage(@Param("gmessage") Gmessage gmessage);

    @Update("update user set nick_name=#{newName},password=#{newPassword},area=#{newArea},email=#{newEmail}," +
            "signature=#{newSentence} where user_id=#{userID}")
    Integer updateInformation(@Param("userID") int userID,
                              @Param("newName") String newName,
                              @Param("newPassword") String newPassword,
                              @Param("newArea") String newArea,
                              @Param("newEmail") String newEmail,
                              @Param("newSentence") String newSentence);

    @Insert("insert into friend(user_id,friend_id) values(#{userID},#{friendID})")
    Integer addFriend(@Param("userID") int userID,@Param("friendID") int friendID);

    @Select("select * from umessage where (msg_from=#{userID} and msg_to=#{friendID}) or (msg_from=#{friendID} and msg_to=#{userID})")
    List<Umessage> getHistory(@Param("userID") int userID,@Param("friendID") int friendID);

    @Delete("delete from umessage where msg_id=#{umessageID}")
    Integer deleteInformation(@Param("umessageID") int umessageID);

    @Delete("delete from friend where user_id=#{userID} and friend_id=#{friendID}")
    Integer deleteFriend(@Param("userID") int userID,@Param("friendID") int friendID);

    @Select("select * from gmessage where gmsg_to=#{groupID}")
    List<Gmessage> getGroupHistory(@Param("groupID") int groupID);

    @Delete("delete from gmessage where gmsg_id=#{gmessageID}")
    Integer deleteGroupMessage(@Param("gmessageID") int gmessageID);
}
```

 