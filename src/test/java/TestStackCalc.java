import com.google.common.base.Joiner;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by rkdgusrnrlrl on 17. 2. 23.
 */
public class TestStackCalc {


    @Ignore
    @Test
    public void CALC_테스트() throws Exception {
        String quest = "(2*(3+6/2)+2)/4+3";
        int result = calc(quest);
        assertThat(result, is(10));
    }

    /*
    *  0. 숫자를 만나면 패스 한다.
    *  1. '(' 를 만나면 스택에 푸쉬를 한다
    *  2. ')' 를 만나면 스택에서 '(' 나올때 까지 팝을 하여출력 하고 ( 는 팝 하여 버림
    *
    * */

    @Test
    public void String에서_한글자씩_짤라서_리턴하는_함수() throws Exception {
        String quest = "12345";
        List<String> list = new ArrayList<>();
        Arrays.asList(quest.split(""))
                .stream()
                .forEach((s) -> {
                    list.add(s);
                });
        String result = Joiner.on("").join(list);
        assertThat(result, is(quest));
    }

    @Test
    public void 숫자를_만나면_패스한다() throws Exception {
        String quest = "123412341";
        Mstack mstack = new Mstack();
        Arrays.asList(quest.split(""))
                .stream()
                .forEach((s) -> {
                    pushBracket(mstack, s);
                });
        try {
            mstack.pop();
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void 사칙연산자와_괄호를_만나면_스택에_푸쉬한다() throws Exception {
        String quest = "3+6/2-44*22";
        Mstack mstack = new Mstack();
        Arrays.asList(quest.split(""))
                .stream()
                .forEach((s) -> {
                    pushBracket(mstack, s);
                });
        try {
            mstack.pop();
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void 여는_괄호를_만나면_스택에_푸쉬를_한다() throws Exception {
        String quest = "(2*(3+6/2)+2)/4+3";
        Mstack mstack = new Mstack();
        Arrays.asList(quest.split(""))
                .stream()
                .forEach((s) -> {
                    pushBracket(mstack, s);
                });

        assertThat(mstack.pop(), is("("));
        assertThat(mstack.pop(), is("("));
        try {
            mstack.pop();
            fail();
        } catch (Exception e) {

        }
    }
    @Test
    public void 닫는괄호를_만나면_여는괄호를_만날때까지_팝을함() throws Exception {

    }

    private void pushBracket(Mstack mstack, String quest) {
        if ("(".equals(quest)) {
            mstack.push(quest);
        }
    }

    private int calc(String quest) {
        return 0;
    }

}
