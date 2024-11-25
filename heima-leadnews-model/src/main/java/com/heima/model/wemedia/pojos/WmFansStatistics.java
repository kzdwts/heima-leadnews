package com.heima.model.wemedia.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自媒体粉丝数据统计表
 * @TableName wm_fans_statistics
 */
@TableName(value ="wm_fans_statistics")
@Data
public class WmFansStatistics implements Serializable {
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
     * 
     */
    private Integer readCount;

    /**
     * 
     */
    private Integer comment;

    /**
     * 
     */
    private Integer follow;

    /**
     * 
     */
    private Integer collection;

    /**
     * 
     */
    private Integer forward;

    /**
     * 
     */
    private Integer likes;

    /**
     * 
     */
    private Integer unlikes;

    /**
     * 
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