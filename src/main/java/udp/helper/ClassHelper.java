package udp.helper;

/**
 * @author sscerbatiuc
 */
public class ClassHelper {

    public static String getCurrentClassName(Object obj){
        Class<?> enclosingClass = obj.getClass().getEnclosingClass();
        return enclosingClass.getName();
    }
}
