package by.bigroi.wear.model.response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class SaltEdit extends BCrypt implements PasswordEncoder {

    private Pattern BCRYPT_PATTERN;
    private final Log logger;
    private final int strength;

    public SaltEdit() {
        this(-1);
    }

    public SaltEdit(int strength) {
        this(strength, (SecureRandom)null);
    }

    public SaltEdit(int strength, SecureRandom random) {
        this.BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
        this.logger = LogFactory.getLog(this.getClass());
        this.strength = strength;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String salt;
        salt = gensalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    public static String gensaltRound(int log_rounds) {
        return gensalt(log_rounds);
    }


    public static String gensalt() {
        return gensaltRound(10);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(encodedPassword != null && encodedPassword.length() != 0) {
            if(!this.BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
                this.logger.warn("Encoded password does not look like BCrypt");
                return false;
            } else {
                return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
            }
        } else {
            this.logger.warn("Empty encoded password");
            return false;
        }
    }
}
