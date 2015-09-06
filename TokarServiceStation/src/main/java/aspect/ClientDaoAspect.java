package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import model.Client;

@Aspect
public class ClientDaoAspect {


    @Before(value = "execution(* dao..*(..))")
    public void loggingAdvice(){
        System.out.println("calling method of clientDaoBean");
    }


}