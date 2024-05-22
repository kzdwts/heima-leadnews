package com.heima.file.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * minio属性配置
 *
 * @author Kang Yong
 * @date 2024/5/22
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties implements Serializable {

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String endpoint;
    private String readPath;

}
