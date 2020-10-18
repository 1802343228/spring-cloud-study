package com.soft1851.content.dto;

import com.soft1851.content.enums.AuditStatusEnum;
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
public class ShareAudioDto {
    private AuditStatusEnum auditStatusEnum;
    private String reason;
}
