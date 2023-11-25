import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.ExampleHibernateApplication;
import org.mycompany.service.ExampleHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExampleHibernateApplication.class)
class ExampleHibernateTest {

    @Autowired
    ExampleHibernateService exampleHibernateService;

    @Test
    void testSave(){
        try{
            exampleHibernateService.save();
        }catch (Exception e){
            Assertions.fail();
        }
    }
}
