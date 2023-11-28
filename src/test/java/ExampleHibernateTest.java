import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.ExampleHibernateApplication;
import org.mycompany.service.ExampleHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExampleHibernateApplication.class)
@Slf4j
class ExampleHibernateTest {

    @Autowired
    ExampleHibernateService exampleHibernateService;

    @Test
    void testSaveMySQL(){
        try{
            exampleHibernateService.saveMySQL();
        }catch (Exception e){
            log.error("Test Failed", e);
            Assertions.fail();
        }
    }
}
