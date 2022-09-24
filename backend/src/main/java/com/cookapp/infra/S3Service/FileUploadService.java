package com.cookapp.infra.S3Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;

@Service
public class FileUploadService {

    private final AmazonS3 s3Client;

    public FileUploadService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public String fileUpload(String img) throws IOException {
        String fileName = DateTime.now().toString("yyyyMMddHHmmssSSS") + "_outputFile.jpeg";

        String backetName = "mtmt-dev";
        String s3PathName = "cookapp/img/" + fileName;
        String outputImgName = "./" + fileName;

        String[] outputImg = img.split(",");
        byte[] bytes = Base64.getDecoder().decode(outputImg[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(outputImgName);
        fileOutputStream.write(bytes);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpeg");

        File file = new File(outputImgName);
        InputStream inputStream = new FileInputStream(file);

        file.delete();

        try {
            s3Client.putObject(backetName, s3PathName, inputStream, metadata);
            return s3PathName;
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
