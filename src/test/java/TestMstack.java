import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rkdgusrnrlrl on 17. 2. 24.
 */
public class TestMstack {
    @Test
    public void FILO테스트() throws Exception {
        Mstack mstack = new Mstack();
        for (int i = 0; i < 5; i++) {
            mstack.push(i+"");
        }
        for (int i = 4; i > -1; i--) {
            assertThat(mstack.pop(), is(i+""));
        }
    }


    @Test(expected = Exception.class)
    public void size_이상_의_값을_pop을_호출할_경우_() throws Exception {
        Mstack mstack = new Mstack();
        for (int i = 0; i < 5; i++) {
            mstack.push(i+"");
        }
        for (int i = 5; i > -1; i--) {
            mstack.pop();
        }
    }

    @Test(expected = Exception.class)
    public void 초기화한_스택에서_pop_호출시() throws Exception {
        Mstack mstack = new Mstack();
        mstack.pop();
    }
}
