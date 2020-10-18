package com.soft1851.content.controller;

import com.soft1851.content.dto.ShareAudioDto;
import com.soft1851.content.entity.Share;
import com.soft1851.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author crq
 */
@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ShareAdminController {
    private final ShareService shareService;

    @PutMapping(value = "/audit/{id}")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAudioDto shareAudioDto) {
        //还需认证授权
        return this.shareService.auditById(id,shareAudioDto);
    }
}
