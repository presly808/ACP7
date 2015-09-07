package ua.artcode.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.artcode.dao.UserDao;
import ua.artcode.exception.NoUserException;
import ua.artcode.exception.ValidationException;
import ua.artcode.exception.WrongUserCredentialException;
import ua.artcode.model.User;
import ua.artcode.util.StringUtils;
import ua.artcode.validation.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private Map<String,User> accessTokenUserMap = new ConcurrentHashMap<>();
    public static final int ACCESS_TOKENT_LENGTH = 10;

    @Autowired
    @Qualifier(value = "jpaUserDao")
    private UserDao userDao;
    private Validator<User> userValidator;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao, Validator<User> validator) {
        this.userValidator = validator;
        this.userDao = userDao;
    }

    @Override
    public User register(String fullname, String phone, String email, String pass) throws ValidationException {
        // compose user from parts
        User user = new User(fullname, email, pass, phone);
        // validation
        // userValidator.isValid(user);



        return userDao.create(user);
    }

    @Override
    public String login(String email, String pass) throws WrongUserCredentialException {

        User user = null;
        try {
            user = userDao.findByEmail(email);
        } catch (NoUserException e) {
            LOGGER.error(e.getMessage(),e);
            throw new WrongUserCredentialException("wrong pass or email");
        }

        if(!pass.equals(user.getPass())){
            LOGGER.warn(String.format("wrong user %s pass", email));
            throw new WrongUserCredentialException("wrong pass or email");
        }

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKENT_LENGTH);
        accessTokenUserMap.put(accessToken,user);

        LOGGER.info("return user access token");


        return accessToken;
    }

    @Override
    public User update(String sessionToken, String fullname, String pass, String phone) {
        return null;
    }

    @Override
    public boolean delete(String sessionToken) {
        return false;
    }

    @Override
    public User getUser(long id) {
        try {
            return userDao.findById(id);
        } catch (NoUserException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public User getUser(String accessToken) {

        return accessTokenUserMap.get(accessToken);
    }
}
