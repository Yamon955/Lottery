package com.lottery;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *      springboot默认扫描启动类同级包和同级的子包内容。那么跨模块扫包需要注意的要点如下：
 *        1.必须将其他包全部引入启动类所在的pom中
 *        2.虽然他们不同模块，但是启动类所在的模块引入了其他所有模块的依赖。在（编译成jar时，同包合并。domain模块的的包也是com.lottery开始。他们会合并扫描。
 *        3. 倘若多个模块起始不一样。那么建议采用@ComponentScans注解。其中必须显式标明启动类所要扫描的模块。因为一旦显示的配置了该注解或者@ComponentScan注解。
 *           那么springboot默认的包扫描机制就会自动失效。
 * @Author Yamon
 * @Create 2023/12/15 20:38
 */
@SpringBootApplication
@Configurable
@EnableDubbo
public class LotteryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }
}
