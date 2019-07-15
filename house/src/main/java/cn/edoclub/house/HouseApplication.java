package cn.edoclub.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.edoclub.house.mapper")
public class HouseApplication {

    public static void main(String[] args){

        SpringApplication.run(HouseApplication.class,args);
    }
}
