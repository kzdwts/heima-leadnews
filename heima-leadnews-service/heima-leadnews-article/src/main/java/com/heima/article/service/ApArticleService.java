package com.heima.article.service;

import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.R;

import java.util.List;

/**
* @author kangy
* @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service
* @createDate 2024-05-15 17:20:42
*/
public interface ApArticleService extends IService<ApArticle> {

    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载更多  2为加载最新
     * @param dto
     * @return
     */
    R<List<ApArticle>> load(Short loadtype, ArticleHomeDto dto);

}
