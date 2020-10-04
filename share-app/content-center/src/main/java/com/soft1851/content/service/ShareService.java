package com.soft1851.content.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.content.dto.ShareDto;
import com.soft1851.content.entity.Share;

/**
 * @author crq
 */
public interface ShareService {
    /**
     * 找信息
     * @param id
     * @return
     */
    ShareDto findById(Integer id);

    /**
     * 根据标题查询某个用户的分享列表数据，title为空则为所有数据，查询结果分页
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> query(String title,Integer pageNo,Integer pageSize,Integer userId);


    /**
     * 测试
     * @return
     */
    String getHello();
}
