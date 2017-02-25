import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rkdgusrnrlrl on 17. 2. 11.
 */
public class TestAlgo {

    @Test
    public void testSum() throws Exception {
        int num = sum(new int[]{1,2,3,4,5,6,7}, 5);
        assertThat(num, is(15));
    }

    private int sum(int[] ints, int i) {
        if (i == 0) return 0;
        return sum(ints, i-1) + ints[i-1];
    }
}
