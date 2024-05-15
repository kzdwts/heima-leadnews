package com.heima.model.article.dtos;

import lombok.Data;

import java.util.Date;

/**
 * 文章首页参数
 *
 * @author Kang Yong
 * @date 2024/5/15
 * @since 1.0.0
 */
@Data
public class ArticleHomeDto {

    // 最大时间
    private Date maxBehotTime;
    // 最小时间
    private Date minBehotTime;
    // 分页size
    private Integer size;
    // 频道ID
    private String tag;
}
