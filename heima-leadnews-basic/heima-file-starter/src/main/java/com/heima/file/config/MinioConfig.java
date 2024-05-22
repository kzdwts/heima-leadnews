package com.heima.file.config;

import com.heima.file.config.properties.MinioProperties;
import com.heima.file.service.FileStorageService;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio Bean
 *
 * @author Kang Yong
 * @date 2024/5/22
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties({MinioProperties.class})
@ConditionalOnClass(FileStorageService.class) // 当引入FileStorageService接口时
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .endpoint(minioProperties.getEndpoint())
                .build();
    }

}
