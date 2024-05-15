package com.heima.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kangy
 * @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Mapper
 * @createDate 2024-05-15 17:20:42
 * @Entity com.heima.model.article.pojos.ApArticle
 */
public interface ApArticleMapper extends BaseMapper<ApArticle> {

    List<ApArticle> loadArticleList(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);

}




