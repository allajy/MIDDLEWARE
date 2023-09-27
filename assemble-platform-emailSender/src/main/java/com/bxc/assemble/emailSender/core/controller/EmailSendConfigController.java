package com.bxc.assemble.emailSender.core.controller;

import com.bxc.assemble.emailSender.core.domain.EmailSendConfigSaveDTO;
import com.bxc.assemble.emailSender.core.bean.EmailSendConfigEntity;
import com.bxc.assemble.emailSender.core.service.MPEmailSendConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 邮箱发送配置 前端控制器
 * </p>
 *
 * @author libo
 * @since 2022-08-13
 */
@Slf4j
@RestController
@RequestMapping("/email/send/config")
public class EmailSendConfigController {


    @Autowired
    MPEmailSendConfigRepository emailSendConfigRepository;



    @RequestMapping("/create")
    public ResponseEntity<EmailSendConfigSaveDTO> createEmailSendConfig(@RequestBody
                                                                        EmailSendConfigSaveDTO
                                                                                    emailSendConfigSaveDTO){

        EmailSendConfigEntity emailSendConfigEntity = emailSendConfigSaveDTO.dto2Po();
        emailSendConfigRepository.save(emailSendConfigEntity);
        return ResponseEntity.ok(emailSendConfigSaveDTO);
    }

}
