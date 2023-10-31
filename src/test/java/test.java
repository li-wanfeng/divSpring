import com.wanfeng.divSpring.entity.User;
import com.wanfeng.divSpring.ioc.divApplicationContext;
import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test01() {
        divApplicationContext divApplicationContext = new divApplicationContext("application.xml");
        User user01 = (User) divApplicationContext.getBean("user01");
        System.out.println("user01 = " + user01);
    }
}
