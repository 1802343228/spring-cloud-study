package com.soft1851.content.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.content.dto.ExchangeDto;
import com.soft1851.content.dto.ShareAudioDto;
import com.soft1851.content.dto.ShareContributeDto;
import com.soft1851.content.dto.ShareDto;
import com.soft1851.content.entity.Share;

import java.util.List;

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
     * 投稿
     * @param shareContributeDto
     * @return
     */
    int putShare(ShareContributeDto shareContributeDto);

    /**
     * 审核投稿完成情况
     * @param id
     * @param shareAudioDto
     * @return
     */
    Share auditById(Integer id, ShareAudioDto shareAudioDto);

    /**
     * 测试
     * @return
     */
    String getHello();

    /**
     * 查询所有
     * @return
     */
    List<Share> findAll();


    /**
     * 兑换
     * @param exchangeDto
     * @return
     */
    Share exchange(ExchangeDto exchangeDto);
}
