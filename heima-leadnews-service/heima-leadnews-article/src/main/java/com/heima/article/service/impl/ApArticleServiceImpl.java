package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.article.pojos.ApArticle;
import com.heima.article.service.ApArticleService;
import com.heima.article.mapper.ApArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author kangy
* @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service实现
* @createDate 2024-05-15 17:20:42
*/
@Service
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle>
    implements ApArticleService{

}




