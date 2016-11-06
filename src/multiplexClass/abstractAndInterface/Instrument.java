package multiplexClass.abstractAndInterface;

/**
 * Created by Administrator on 2016/10/18.
 */
abstract class Instrument {
    private int i;
    public abstract void play(int i);   //只要包含抽象方法，该类必须abstract 抽象类没有方法体。而且抽象方法必须没有方法体
    public String what(){return "sadfsd";};
}
