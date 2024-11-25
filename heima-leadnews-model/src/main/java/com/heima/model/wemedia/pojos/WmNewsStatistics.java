package com.heima.model.wemedia.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自媒体图文数据统计表
 * @TableName wm_news_statistics
 */
@TableName(value ="wm_news_statistics")
@Data
public class WmNewsStatistics implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 主账号ID
     */
    private Integer userId;

    /**
     * 子账号ID
     */
    private Integer article;

    /**
     * 阅读量
     */
    private Integer readCount;

    /**
     * 评论量
     */
    private Integer comment;

    /**
     * 关注量
     */
    private Integer follow;

    /**
     * 收藏量
     */
    private Integer collection;

    /**
     * 转发量
     */
    private Integer forward;

    /**
     * 点赞量
     */
    private Integer likes;

    /**
     * 不喜欢
     */
    private Integer unlikes;

    /**
     * 取消关注量
     */
    private Integer unfollow;

    /**
     * 
     */
    private String burst;

    /**
     * 创建时间
     */
    private Date createdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}