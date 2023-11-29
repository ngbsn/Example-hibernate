import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.postgres1.ExamplePostgres1Application;
import org.mycompany.postgres1.service.ExampleHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamplePostgres1Application.class)
@Slf4j
class ExampleHibernateTest {

    @Autowired
    ExampleHibernateService exampleHibernateService;

    @Test
    void testSavePostgres1(){
        try{
            exampleHibernateService.savePostgres1();
        }catch (Exception e){
            log.error("Test Failed", e);
            Assertions.fail();
        }
    }
}
