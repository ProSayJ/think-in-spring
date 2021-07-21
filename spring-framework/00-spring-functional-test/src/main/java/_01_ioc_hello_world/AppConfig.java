package _01_ioc_hello_world;

import org.springframework.context.annotation.anno_.Bean;
import org.springframework.context.annotation.anno_.ComponentScan;
import org.springframework.context.annotation.anno_.Configuration;

/**
 * 1、默认情况下bean的名称和方法名称相同，也可以使用name属性来指定：
 *
 * @author yangjian
 * @since 1.0.0 <br>  2021-07-20 上午 09:52
 */
@Configuration
@ComponentScan("_01_ioc_hello_world")
class AppConfig {

    @Bean
    public PersonDomain person() {
        return new PersonDomain();
    }

    @Bean
    public PersonDomain person2() {
        return new PersonDomain();
    }

    @Bean(name = {"personName1", "personName2", "/personName3"})
    public PersonDomain createBean3() {
        return new PersonDomain();
    }

    @Bean(value = "/person2")
    public PersonDomain createBean4() {
        return new PersonDomain();
    }
}
