package com.soft1851.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crq
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenRespDto {
    private String token;
    private Long expirationTime;
}
