package com.soft1851.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.contentcenter.domain.dto.ExchangeDTO;
import com.soft1851.contentcenter.domain.dto.ShareAuditDTO;
import com.soft1851.contentcenter.domain.dto.ShareDTO;
import com.soft1851.contentcenter.domain.dto.ShareRequestDTO;
import com.soft1851.contentcenter.domain.entity.Share;

import java.util.List;

/**
 * @author zhao
 * @className ShareService
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/

public interface ShareService {
    /**
     * 获得分享详情
     * @return  ShareDTO
     */
    ShareDTO findById(Integer id);

    /**
     * 根据用户查询分享列表
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId);

    /**
     * 投稿
     * @param shareRequestDTO
     * @return
     */
    int contribute(ShareRequestDTO shareRequestDTO);

    /**
     * 审核投稿
     * @param id
     * @param shareAuditDTO
     * @return
     */
    Share auditById(Integer id, ShareAuditDTO shareAuditDTO);


    /**
     * 积分兑换资源
     *
     * @param exchangeDTO
     * @return Share
     */
    Share exchange(ExchangeDTO exchangeDTO);

    /**
     * 根据userId查询我的兑换
     * @param userId
     * @return
     */
    List<Share> findExchangeById(Integer userId);

    /**
     * 测试接口
     * @return
     */
    String getHello();

    /**
     * 查找我的投稿
     * @param userId
     * @return
     */
    List<Share> findMyContribute(Integer userId);
}


