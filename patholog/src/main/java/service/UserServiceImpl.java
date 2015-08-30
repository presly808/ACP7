package service;

import dao.UserDao;
import exception.NoUserException;
import exception.ValidationException;
import exception.WrongUserCredentialException;
import model.User;
import util.StringUtils;
import validation.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by serhii on 15.08.15.
 */
public class UserServiceImpl implements UserService {


    private Map<String, User> accessTokenUserMap = new ConcurrentHashMap<>();
    public static final int ACCESS_TOKENT_LENGTH = 10;
    private UserDao userDao;
    private Validator<User> userValidator;


    public UserServiceImpl(UserDao userDao, Validator<User> validator) {
        this.userValidator = validator;
        this.userDao = userDao;
    }

    @Override
    public User register(String fullname, String rank, String email, String phone, String login, String pass) throws ValidationException {
        // compose user from parts
        User user = new User(fullname, rank, email, login, pass, phone);
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
            throw new WrongUserCredentialException("wrong pass or email");
        }

        if(!pass.equals(user.getPass())){
            throw new WrongUserCredentialException("wrong pass or email");
        }

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKENT_LENGTH);
        accessTokenUserMap.put(accessToken,user);

        return accessToken;
    }

    @Override
    public User update(String sessionToken, String fullname, String login, String pass, String email, String rank, String phone) {
        return null;
    }

    @Override
    public boolean delete(String sessionToken) {
        return false;
    }
}
