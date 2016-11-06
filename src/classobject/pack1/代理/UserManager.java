package classobject.pack1.代理;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface UserManager{
    void addUser(String userId, String userName);
    void delUser(String userId);
    String findUser(String userId);
    void modifyUser(String userId, String userName);
}
