package com.heima.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * APP已发布文章配置表
 * @TableName ap_article_config
 */
@TableName(value ="ap_article_config")
@Data
public class ApArticleConfig implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 是否可评论
     */
    private Integer isComment;

    /**
     * 是否转发
     */
    private Integer isForward;

    /**
     * 是否下架
     */
    private Integer isDown;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}