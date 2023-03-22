import java.util.*;
public class Flattener {
   
    @SuppressWarnings("unchecked")
    List<Object> flatten(List<Object> list) {
        List<Object> newList = new ArrayList<>();
        for (Object x: list) {
            if (x instanceof List)
                newList.addAll(flatten((List<Object>) x));
            else if (x != null)
                newList.add(x);
        }
        return newList;
    }
}
