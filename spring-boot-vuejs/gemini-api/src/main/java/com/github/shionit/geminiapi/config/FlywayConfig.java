package com.github.shionit.geminiapi.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by @shionit on 2018/10/08.
 */
@Configuration
public class FlywayConfig {

    @Bean
    public FlywayMigrationStrategy strategy() {
        return flyway -> {
            // flyway_schema_historyの初期化
            flyway.clean();
            // マイグレーション実行
            flyway.migrate();
        };
    }
}
