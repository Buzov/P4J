package test;


import com.barracuda.p4j.crypto.hash.PasswordHashTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    RemoveStudentDataTest.class, 
    CryptoTest.class,
    PasswordHashTest.class})
public class AllDataTests {

}
