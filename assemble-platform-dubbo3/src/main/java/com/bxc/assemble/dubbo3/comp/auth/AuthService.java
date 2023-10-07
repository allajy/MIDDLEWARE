package com.bxc.assemble.dubbo3.comp.auth;

import cn.hutool.crypto.SecureUtil;
import com.bxc.assemble.common.util.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Data
@Slf4j
@NoArgsConstructor
public class AuthService {


    public  final String AUTH_SECRET_KEY = "dubbo.secret.key";

    public  final String AUTH_APP_KEY = "dubbo.app.key";

    private String appKey;

    private String secretKey;

    /**
     * 匹配ak和sk的值
     * @param appKey
     * @param secretKey
     * @return
     */
    public boolean matchSecretKey(String appKey,String secretKey){
        log.info("local-appkey:{} - local-secretKey:{}",this.appKey,this.secretKey);
        log.info("remote-appkey:{} - remote-secretKey:{}",appKey,secretKey);
        if(StringUtils.isEmpty(appKey)){
            return Boolean.FALSE;
        }
        if(this.appKey.equals(appKey)){
            if(StringUtils.isEmpty(secretKey)){
                return Boolean.FALSE;
            }
            else if(!SecureUtil.md5(this.secretKey).equals(secretKey)){
                return Boolean.FALSE;
            }
        }else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
