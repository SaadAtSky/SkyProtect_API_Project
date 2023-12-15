package com.sky.events_api_project.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.services.s3.S3Client;

@ExtendWith(MockitoExtension.class)
public class S3ServiceUnitTest {
    @Mock
    S3Client s3Client;
    @InjectMocks
    S3Service s3Service;

//    @Test
//    public void givenEvents_whenExportToS3_thenReturnSuccessStatus(){
            // TBD
//    }
//    @Test
//    public void givenErrorConnectedToS3Client_whenExportToS3_thenReturnError(){
            // TBD
//    }
}
