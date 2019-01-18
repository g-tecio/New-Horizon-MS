package com.cwgx.newhorizon.Services.S3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage/")
public class BucketController {

    /*
    *
    * Initialize an object from the AmazonClient class (to make the "connection"
    * with S3)
    * */
    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    /*
    *
    * Path to store an image: https://thedomain/uploadFile
    * A key named "file" is needded
    * */

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    /*
    *
    * Path to delete an image: https://thedomain/deleteFile
    * A key named "url" is needded
    * */
    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}
