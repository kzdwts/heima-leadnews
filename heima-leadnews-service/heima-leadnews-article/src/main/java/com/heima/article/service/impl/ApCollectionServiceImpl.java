package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.article.pojos.ApCollection;
import com.heima.article.service.ApCollectionService;
import com.heima.article.mapper.ApCollectionMapper;
import org.springframework.stereotype.Service;

/**
* @author kangy
* @description 针对表【ap_collection(APP收藏信息表)】的数据库操作Service实现
* @createDate 2024-05-15 17:20:42
*/
@Service
public class ApCollectionServiceImpl extends ServiceImpl<ApCollectionMapper, ApCollection>
    implements ApCollectionService{

}




