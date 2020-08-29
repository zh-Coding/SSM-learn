import com.czh.Config.SpringConfig;
import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import com.czh.service.impl.AccountServiceImpl;
import com.czh.ui.Client1;
import com.czh.utils.ConnectionUtils;
import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 13:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService as;
    @Autowired
    private Client1 cl;
    @Autowired
    private ConnectionUtils connectionUtils;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountDao accountDao;


    @Test
    public void test3(){
        List<Account3> all = accountDao.findAll();
        all.forEach(System.out::println);
    }


    @Test
    public void testTransfer(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        AccountService as = context.getBean("asProxy", AccountService.class);
        as.transfer("aaa","bbb",100.0f);
    }

    @Test
    public void test2(){
        System.out.println(cl.as);
        System.out.println("*********");

        AccountServiceImpl acc = new AccountServiceImpl();
        System.out.println(acc);
    }
}
