package cn.elitecode.web.config;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LocalDateTimeConfig {

    /*
     * 序列化内容
     *   Date -> String
     * 服务端返回给客户端内容
     * */
    @Bean
    public DateSerializer DateSerializer() {
        return new DateSerializer(false, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /*
     * 反序列化内容
     *   String -> Date
     * 客户端传入服务端数据
     * */
    @Bean
    public DateDeserializers.DateDeserializer DateDeserializer() {
        return new DateDeserializers.DateDeserializer(new DateDeserializers.DateDeserializer(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
    }

    // 配置
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.serializerByType(Date.class, DateSerializer());
            builder.deserializerByType(Date.class, DateDeserializer());
        };
    }

}