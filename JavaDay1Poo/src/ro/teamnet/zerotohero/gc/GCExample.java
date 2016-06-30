package ro.teamnet.zerotohero.gc;
import java.lang.*;

/**
 * Created by user on 6/30/2016.
 */
public class GCExample {
    public static void main(String[] args) {
        while(true) {
            new DemoObject();
        }
    }

//    public static void main(String[] args) {
//        List<DemoObject> demoObjects = new ArrayList<DemoObject>();
//        while(true) {
//            demoObjects.add(new DemoObject());
//        }
//    }


}
