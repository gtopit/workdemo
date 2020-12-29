import org.junit.Test;

import java.util.function.Function;

public class TestCase {

    @Test
    public void Test() {
        String hello = fun("hello", (str) -> {
            return str;
        });

        System.out.println(hello);
    }

    public String fun(String timeUnit, Function<String, String> func) {
        System.out.println(timeUnit);
        return func.apply(timeUnit + "--out");
    }


}
