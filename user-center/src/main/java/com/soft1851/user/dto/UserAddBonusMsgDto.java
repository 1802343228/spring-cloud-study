package com.soft1851.user.dto;

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
    private Integer userId;

    /**
     * 积分
     */
    private Integer bonus;
}
