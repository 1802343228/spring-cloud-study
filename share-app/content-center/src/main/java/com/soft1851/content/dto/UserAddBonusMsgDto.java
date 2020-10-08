package com.soft1851.content.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddBonusMsgDto {

    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId",value = "分享人id")
    private Integer userId;

    /**
     * 积分
     */
    @ApiModelProperty(name = "bonus",value = "用户积分")
    private Integer bonus;
}
