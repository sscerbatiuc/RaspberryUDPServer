package udp.helper;

/**
 * Created by stas on 2/5/16.
 */
public class ClassHelper {

    public static String getCurrentClassName(Object obj){
        Class<?> enclosingClass = obj.getClass().getEnclosingClass();
        return enclosingClass.getName();
    }
}
