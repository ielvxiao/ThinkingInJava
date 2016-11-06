package InnerClass.ExtendInnerClass;

/**
 * Created by Administrator on 2016/10/20.
 */
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi){
        wi.super();
    }
}
