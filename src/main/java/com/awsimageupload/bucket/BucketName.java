package com.awsimageupload.bucket;

public enum BucketName {

    BUCKETNAME("kiron-store");

    private final String bucketName;
   
    BucketName(String bucketName) {
        this.bucketName = bucketName;
      
    }

    public String getBucketName() {
        return bucketName;
    }
}
