package com.soft1851.content.service;

import com.soft1851.content.entity.Notice;

/**
 * @author crq
 */
public interface NoticeService {
    /**
     * 查询最新公告
     * @return
     */
    Notice getLatest();
}
