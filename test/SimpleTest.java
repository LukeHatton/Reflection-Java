import org.junit.Test;

import com.lukehatton.reflection.GetInformationFromClass;

/**
 * ClassName: SimpleTest
 * Description:
 * Author: lizhao
 * Date: 2020/11/20 20:51
 * History:
 */
public class SimpleTest {
    @Test
    public void test01() {
        GetInformationFromClass.getClassMessage(String.class);
    }
}
