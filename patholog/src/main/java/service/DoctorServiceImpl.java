package service;

import dao.DoctorDao;
import exception.NoUserException;
import exception.ValidationException;
import exception.WrongUserCredentialException;
import model.Doctor;
import util.StringUtils;
import validation.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by serhii on 15.08.15.
 */
public class DoctorServiceImpl implements DoctorService {


    private Map<String, Doctor> accessTokenUserMap = new ConcurrentHashMap<>();
    public static final int ACCESS_TOKENT_LENGTH = 10;
    private DoctorDao doctorDao;
    private Validator<Doctor> userValidator;


    public DoctorServiceImpl(DoctorDao doctorDao, Validator<Doctor> validator) {
        this.userValidator = validator;
        this.doctorDao = doctorDao;
    }

    @Override
    public Doctor register(String fullname, String rank, String email, String phone, String login, String pass) throws ValidationException {
        // compose user from parts
        Doctor doctor = new Doctor(fullname, rank, email, phone, login, pass);
        // validation
        // userValidator.isValid(user);

        return doctorDao.create(doctor);
    }

    @Override
    public String login(String email, String pass) throws WrongUserCredentialException {

        Doctor doctor = null;
        try {
            doctor = doctorDao.findByEmail(email);
        } catch (NoUserException e) {
            throw new WrongUserCredentialException("wrong pass or email");
        }

        if(!pass.equals(doctor.getPass())){
            throw new WrongUserCredentialException("wrong pass or email");
        }

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKENT_LENGTH);
        accessTokenUserMap.put(accessToken, doctor);

        return accessToken;
    }

    @Override
    public Doctor update(String sessionToken, String fullname, String login, String pass, String email, String rank, String phone) {
        return null;
    }

    @Override
    public boolean delete(String sessionToken) {
        return false;
    }
}
