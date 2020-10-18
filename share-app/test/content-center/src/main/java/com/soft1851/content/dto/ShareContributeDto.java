package com.soft1851.content.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author crq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareContributeDto {

    /**
     * 下载数
     */
    @Column(name = "buy_count")
    @ApiModelProperty(name = "buyCount",value = "购买数量")
    private Integer buyCount;

    /**
     * 标题
     */
    @Column(name = "title")
    @ApiModelProperty(name = "title",value = "分享内容标题")
    private String title;


    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
    @ApiModelProperty(name = "isOriginal",value = "是否原创")
    private Boolean isOriginal;

    /**
     * 作者
     */
    @Column(name = "author")
    @ApiModelProperty(name = "author",value = "文章作者")
    private String author;


    /**
     * 概要信息
     */
    @Column(name = "summary")
    @ApiModelProperty(name = "summary",value = "文章作者")
    private String summary;

    /**
     * 价格（需要的积分）
     */
    @Column(name = "price")
    @ApiModelProperty(name = "price",value = "价格")
    private Integer price;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    @ApiModelProperty(name = "downloadUrl",value = "网盘地址")
    private String downloadUrl;


}
