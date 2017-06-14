package ch.bfh.bti7081.s2017.green.event;

import green.auth.UserProfile;
import green.mvp.event.Event;

/**
 * Created by Lukas on 26.05.2017.
 */
public final class UserLoginRequestedEvent extends Event {
    private UserProfile profile;

    public UserLoginRequestedEvent (UserProfile profile) {
        this.profile = profile;
    }

    /**
     * @return whether a userprofile could be fetched or not.
     */
    public boolean hasProfile () {
        return this.profile != null;
    }

    public String getFirstName () {
        return profile.getFirstName();
    }

    public String getLastName () {
        return profile.getLastName();
    }

    public String getIdentifier () {
        return profile.getIdentifier();
    }

    public String getImageUrl () {
        return profile.getImgUrl();
    }
}
