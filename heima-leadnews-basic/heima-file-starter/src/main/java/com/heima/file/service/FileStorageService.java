package com.heima.file.service;

import java.io.InputStream;

/**
 * 文件操作
 *
 * @author Kang Yong
 * @date 2024/5/22
 * @since 1.0.0
 */
public interface FileStorageService {

    /**
     * 上传图片文件
     *
     * @param prefix      {@link String} 文件前缀
     * @param filename    {@link String} 文件名
     * @param inputStream {@link InputStream} 文件流
     * @return {@link String} 文件全路径
     * @author Kang Yong
     * @date 2024/5/22
     */
    String uploadImgFile(String prefix, String filename, InputStream inputStream);

    /**
     * 上传html文件
     *
     * @param prefix      {@link String} 文件前缀
     * @param filename    {@link String} 文件名
     * @param inputStream {@link InputStream} 文件流
     * @return {@link String} 文件全路径
     * @author Kang Yong
     * @date 2024/5/22
     */
    String uploadHtmlFile(String prefix, String filename, InputStream inputStream);

    /**
     * 删除文件
     *
     * @param pathUrl {@link String} 文件全路径
     * @author Kang Yong
     * @date 2024/5/22
     */
    void delete(String pathUrl);

    /**
     * 下载文件
     *
     * @param pathUrl {@link String} 文件全路径
     * @return {@link byte[]}
     * @author Kang Yong
     * @date 2024/5/22
     */
    byte[] downLoadFile(String pathUrl);

}
