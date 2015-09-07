package ua.artcode.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import ua.artcode.model.User;

//@Aspect
public class UserDaoAspect {


    //@Before(value = "execution(* ua.artcode.dao..*(..))")
    public void loggingAdvice(){
        System.out.println("calling method of userDaoBean");
    }


}
