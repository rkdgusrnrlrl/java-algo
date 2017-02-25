import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkdgusrnrlrl on 17. 2. 24.
 */
public class Mstack {
    List<String> store;
    int index;

    public Mstack() {
        store = new ArrayList<String>();
        index = 0;
    }

    public void push(String s) {
        store.add(s);
        index++;
    }

    public String pop() throws Exception {
        if (index > 0) {
            index--;
            return store.get(index);
        } else {
            throw new Exception("stackunder flow");
        }
    }
}
