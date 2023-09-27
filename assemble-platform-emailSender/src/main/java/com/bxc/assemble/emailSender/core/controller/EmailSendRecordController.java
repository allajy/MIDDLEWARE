package com.bxc.assemble.emailSender.core.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bxc.assemble.emailSender.core.domain.EmailSendConfigSaveDTO;
import com.bxc.assemble.emailSender.core.domain.EmailSendRecordDTO;
import com.bxc.assemble.emailSender.core.model.SimpleEmail;
import com.bxc.assemble.emailSender.core.sender.NeteaseSimpleEmailSender;
import com.bxc.assemble.emailSender.core.bean.EmailSendConfigEntity;
import com.bxc.assemble.emailSender.core.service.MPEmailSendConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 邮箱发送记录表 前端控制器
 * </p>
 *
 * @author libo
 * @since 2022-08-13
 */
@RestController
@RequestMapping("/email/send/record")
public class EmailSendRecordController {


    @Autowired
    MPEmailSendConfigRepository emailSendConfigRepository;


    @RequestMapping("/send")
    public ResponseEntity<EmailSendConfigSaveDTO> createEmailSendConfig(@RequestBody
                                                                        EmailSendRecordDTO emailSendRecordDTO){
        NeteaseSimpleEmailSender neteaseSimpleEmailSender = new NeteaseSimpleEmailSender();
        EmailSendConfigEntity emailSendConfigEntity = new EmailSendConfigEntity();
        emailSendConfigEntity.setNamespace(emailSendRecordDTO.getNamespace());
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper(emailSendConfigEntity);
        emailSendConfigEntity  = emailSendConfigRepository.getOne(lambdaQueryWrapper);
        neteaseSimpleEmailSender.setHost(emailSendConfigEntity.getHostname());
        neteaseSimpleEmailSender.setUsername(emailSendConfigEntity.getUsername());
        neteaseSimpleEmailSender.setPassword(emailSendConfigEntity.getPassword());
        neteaseSimpleEmailSender.setPort(emailSendConfigEntity.getPort());
        neteaseSimpleEmailSender.setEncoding(emailSendConfigEntity.getEncoding());
        neteaseSimpleEmailSender.send(new SimpleEmail(emailSendRecordDTO.getReceUsers(),
                emailSendRecordDTO.getContent()));
        return null;
    }

}
