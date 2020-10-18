package com.soft1851.content.service.Impl;

import com.soft1851.content.entity.Notice;
import com.soft1851.content.mapper.NoticeMapper;
import com.soft1851.content.service.NoticeService;
import tk.mybatis.mapper.entity.Example;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author crq
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Override
    public Notice getLatest() {
        Example example = new Example(Notice.class);
        //id降序
        example.setOrderByClause("id DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showFlag",1);
        return noticeMapper.selectByExample(example).get(0);
    }
}
