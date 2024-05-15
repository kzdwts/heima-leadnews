package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.article.pojos.ApArticleConfig;
import com.heima.article.service.ApArticleConfigService;
import com.heima.article.mapper.ApArticleConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author kangy
* @description 针对表【ap_article_config(APP已发布文章配置表)】的数据库操作Service实现
* @createDate 2024-05-15 17:20:42
*/
@Service
public class ApArticleConfigServiceImpl extends ServiceImpl<ApArticleConfigMapper, ApArticleConfig>
    implements ApArticleConfigService{

}




