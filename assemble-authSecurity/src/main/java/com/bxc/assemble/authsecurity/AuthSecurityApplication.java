/**
 * Copyright [2020] [LiBo/Alex of copyright 171779852@qq.com ]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bxc.assemble.authsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @project-name:callcenter
 * @package-name:com.bxc.callcenter
 * @author:LiBo/Alex
 * @create-date:2021-12-11 7:53 下午
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
@SpringBootApplication
@MapperScan("com.bxc.assemble.authsecurity.rbac.dao")
public class AuthSecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(AuthSecurityApplication.class,args);
    }

}
