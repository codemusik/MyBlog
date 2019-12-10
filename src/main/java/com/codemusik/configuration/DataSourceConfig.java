package com.codemusik.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.codemusik.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

        @Autowired
        private Environment env;

        @Bean
        public DataSource getDataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(env.getProperty("spring.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.datasource.username"));
            String password_encryption = env.getProperty("spring.datasource.password");
            String password_decryption = AESUtil.aesDecode(password_encryption);
            dataSource.setPassword(password_decryption);
            return dataSource;
        }
}
