package com.bxc.assemble.emailSender.core.datasource;

import com.bxc.assemble.emailSender.core.model.EmailSenderProperties;

import java.util.List;

/**
 * EmailSenderPropertiesDataSource
 *
 * @author kancy
 * @date 2020/2/20 3:24
 */
public interface EmailSenderPropertiesDataSource {

    /**
     * 加载
     * @return
     */
    List<EmailSenderProperties> load();

}
