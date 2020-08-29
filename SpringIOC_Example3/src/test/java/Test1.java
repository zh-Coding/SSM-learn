import com.czh.config.SpringConfiguration;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Spring整合Junit
 * 1.导入spring-test jar包
 * 2.使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *    @Runwith
 * 3.告知spring运行器，spring和ioc创建是基于xml还是注解，并说明位置
 * @ContextConfiguration
 *      locations:指定xml文件位置，加上classpath：关键字，表示在类路径下
 *      classes：指定注解类位置
 *
 *
 * @author zhCoding
 * @Description:
 * @create 19:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test1 {

    @Autowired
    private AccountService asi;

    @Test
    public void test1(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner qr = context.getBean("getQueryRunner", QueryRunner.class);
        QueryRunner qr2 = context.getBean("getQueryRunner", QueryRunner.class);

        System.out.println(qr == qr2);
    }

    @Test
    public void test2(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService asi = context.getBean("accountServiceImpl", AccountService.class);
        Account3 byId = asi.findById(2);
        System.out.println(byId);
        List<Account3> all = asi.findAll();
        for (Account3 account3 : all) {
            System.out.println(account3);
        }
        AnnotationConfigApplicationContext context1 = (AnnotationConfigApplicationContext) context;
        context1.close();
        System.out.println("*************************");
        ApplicationContext context2 = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService asi2 = context2.getBean("accountServiceImpl", AccountService.class);
        System.out.println(asi2.findById(2));
    }

    @Test
    public void test3(){
        List<Account3> all = asi.findAll();
        for (Account3 account3 : all) {
            System.out.println(account3);
        }
    }

}
