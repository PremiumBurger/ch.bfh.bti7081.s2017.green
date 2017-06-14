package green.auth;

import com.restfb.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Lukas on 12.06.2017.
 */
@Component
public class UserContext {
    private long userId;
    private String firstname;
    private String lastname;
    private String identifier;
    private String imageUrl;

    public void setUserContext(long userId, String firstname, String lastname, String identifier, String imageUrl) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.identifier = identifier;
        this.imageUrl = imageUrl;
    }

    public boolean isAuthenticated() {
        return !StringUtils.isBlank(identifier);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void logout () {
        this.identifier = null;
        this.firstname = null;
        this.lastname = null;
        this.imageUrl = null;
    }

    public long getUserId() {
        return userId;
    }
}