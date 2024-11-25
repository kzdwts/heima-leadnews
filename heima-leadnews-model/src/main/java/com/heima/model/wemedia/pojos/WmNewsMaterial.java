package com.heima.model.wemedia.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 自媒体图文引用素材信息表
 * @TableName wm_news_material
 */
@TableName(value ="wm_news_material")
@Data
public class WmNewsMaterial implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 素材ID
     */
    private Integer materialId;

    /**
     * 图文ID
     */
    private Integer newsId;

    /**
     * 引用类型
            0 内容引用
            1 主图引用
     */
    private Integer type;

    /**
     * 引用排序
     */
    private Integer ord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}