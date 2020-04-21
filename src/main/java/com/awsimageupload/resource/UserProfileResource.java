package com.awsimageupload.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.awsimageupload.model.UserProfile;
import com.awsimageupload.profile.UserProfileService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserProfileResource {

	private final UserProfileService userProfileService;

	@Autowired
	public UserProfileResource(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@ApiOperation(value = "View a list of available UserProfiles", response = List.class)
	@GetMapping
	public List<UserProfile> getUserProfiles() {
		return userProfileService.getUserProfiles();
	}

	@ApiOperation(value = "Upload Image", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(path = "{userProfileId}/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void uploadUserProfileImage(@PathVariable("userProfileId") String userProfileId,
			@RequestParam("file") MultipartFile file) {
		userProfileService.uploadUserProfileImage(userProfileId, file);
	}

	@ApiOperation(value = "Download Image", response = Byte.class)
	@GetMapping("{userProfileId}/image/download")
	public byte[] downloadUserProfileImage(@PathVariable("userProfileId") String userProfileId) {
		return userProfileService.downloadUserProfileImage(userProfileId);
	}

}
