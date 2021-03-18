import cn.demo.domain.Order;
import cn.demo.domain.OrderDao;
import cn.demo.domain.User;
import cn.demo.domain.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.text.normalizer.UnicodeSet;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.List;

public class test {
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        InputStream configStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configStream);
        session = factory.openSession();
    }

    @Test
    public void test() throws Exception {
        OrderDao dao = session.getMapper(OrderDao.class);
        Order order = dao.selectByPrimaryKey(1);
        System.out.println(order);
    }

    @Test
    public void test2() throws Exception {
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void test3() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
    }
}
