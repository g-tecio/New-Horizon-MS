package com.cwgx.newhorizon.Services.S3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class AmazonClient {

    private AmazonS3 s3Client;
    @Value("${gkz.aws.access_key_id}")
    private String awsId;
    @Value("${endpointUrl}")
    private String endpointUrl;
    @Value("${gkz.s3.bucket}")
    private String bucketName;
    @Value("${gkz.aws.secret_access_key}")
    private String awsKey;
    @Value("${gkz.s3.region}")
    private String region;

    /*
    *
    * Make a connection with AWS
    * */

    @PostConstruct
    private void initializeAmazon() {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
        s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

    }

    /*
    *
    *Convert the image from multipart file to a single file so the image
    * gets stored as a .JPG file
    **/

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    /*
    *
    * Rename the image with a Timestamp and the image's name
    * */
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    /*
    *
    * Send the S3 object to the bucket
    * */
    private void uploadFileTos3bucket(String fileName, File file) {
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }
    /*
    *
    *Get back the URL where the image is stored
    * */
    public String uploadFile(MultipartFile multipartFile) {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "IT WORKS!!" + fileUrl;
    }

    /*
    *
    * Delete the image from the bucket with the URL
    * */
    public String deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3Client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
        return "Successfully deleted";
    }


}
