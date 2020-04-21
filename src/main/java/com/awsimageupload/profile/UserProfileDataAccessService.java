package com.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.awsimageupload.datastore.UserProfileDataStore;
import com.awsimageupload.model.UserProfile;

import java.util.List;

@Repository
public class UserProfileDataAccessService {

    private final UserProfileDataStore userProfileDataStore;

    @Autowired
    public UserProfileDataAccessService(UserProfileDataStore userProfileDataStore) {
        this.userProfileDataStore = userProfileDataStore;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileDataStore.getUserProfiles();
    }
}
