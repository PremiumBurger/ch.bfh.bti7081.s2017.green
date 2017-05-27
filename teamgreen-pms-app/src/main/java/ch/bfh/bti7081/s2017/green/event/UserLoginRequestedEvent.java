package ch.bfh.bti7081.s2017.green.event;

/**
 * Created by Lukas on 26.05.2017.
 */
public final class UserLoginRequestedEvent {
    private final String userName, password;

    public UserLoginRequestedEvent (final String userName, final String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName () {
        return userName;
    }

    public String getPassword () {
        return password;
    }
}
