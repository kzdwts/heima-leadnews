package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.article.pojos.ApAuthor;
import com.heima.article.service.ApAuthorService;
import com.heima.article.mapper.ApAuthorMapper;
import org.springframework.stereotype.Service;

/**
* @author kangy
* @description 针对表【ap_author(APP文章作者信息表)】的数据库操作Service实现
* @createDate 2024-05-15 17:20:42
*/
@Service
public class ApAuthorServiceImpl extends ServiceImpl<ApAuthorMapper, ApAuthor>
    implements ApAuthorService{

}




