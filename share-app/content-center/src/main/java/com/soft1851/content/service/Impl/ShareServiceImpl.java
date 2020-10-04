package com.soft1851.content.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soft1851.content.dto.ShareDto;
import com.soft1851.content.dto.UserDto;
import com.soft1851.content.entity.MidUserShare;
import com.soft1851.content.entity.Share;
import com.soft1851.content.feignclient.UserCenterFeignClient;
import com.soft1851.content.mapper.MidUserShareMapper;
import com.soft1851.content.mapper.ShareMapper;
import com.soft1851.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author crq
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ShareServiceImpl implements ShareService {
    private final ShareMapper shareMapper;
    private final MidUserShareMapper midUserShareMapper;
    private final UserCenterFeignClient userCenterFeignClient;

    @Override
    public ShareDto findById(Integer id) {
        // 获取分享实体
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 获得发布人id
        Integer userId = share.getUserId();

        UserDto userDTO = this.userCenterFeignClient.findUserById(userId);

        ShareDto shareDTO = new ShareDto();
        // 属性的装配
//        BeanUtils.copyProperties(share, shareDTO);
//        shareDTO.setWxNickname(userDTO.getWxNickname());
        shareDTO.setShare(share);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

    @Override
    public PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId) {
        //启动分页
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(Share.class);
        Example.Criteria criteria = example.createCriteria();
        //如标题关键字不空，则加上模糊查询条件，否则结果即所有数据
        if(StringUtil.isNotEmpty(title)){
            criteria.andLike("title","%"+title+"%");

        }
        //执行按条件查询
        List<Share> shares = this.shareMapper.selectByExample(example);
        //处理后的share数据表
        List<Share> sharesDeal;
        //如果用户未登录，那么下载地址全设为Null
        if(userId == null) {
            sharesDeal = shares.stream()
                    .peek(share -> {
                        share.setDownloadUrl(null);
                    })
                    .collect(Collectors.toList());
        }
        //如果用户登录了，那么查询一下mid_user_share，如果没有数据，那么这条share的downloadURl也设置为Null
        //只有自己分享的资源才能直接看到下载连接，否则显示“兑换”
        else{
            sharesDeal = shares.stream()
                    .peek(share -> {
                        MidUserShare midUserShare = this.midUserShareMapper.selectOne(
                                MidUserShare.builder()
                                .userId(userId)
                                .shareId(share.getId())
                                .build()
                        );
                        if(midUserShare == null) {
                            share.setDownloadUrl(null);
                        }
                    })
                    .collect(Collectors.toList());
        }
        return new PageInfo<>(sharesDeal);
    }

    @Override
    public String getHello() {
        return userCenterFeignClient.getHello();
    }
}
