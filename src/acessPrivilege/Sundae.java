package acessPrivilege;

/**
 * Created by Administrator on 2016/10/14.
 */
 class Sundae {
    private Sundae (){
        System.out.print(1);
    }
    static Sundae makeASudae(){
        return new Sundae();
    }
}
