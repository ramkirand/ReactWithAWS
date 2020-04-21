package com.awsimageupload.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.awsimageupload.model.UserProfile;

@Repository
public class UserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile("kiron-store", "MyPhoto", null));
        USER_PROFILES.add(new UserProfile("kiron-store", "MyPhoto", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

}
