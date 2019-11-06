package com.example.basedemo.local;

import com.example.basedemo.config.RootConfig;
import com.example.basedemo.config.WebConfig;
import com.example.basedemo.dao.mappers.CustomerMapper;
import com.example.basedemo.pojo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
public class EnvironmentTest {

    @Autowired
    private SqlSessionFactory factory;

//    @Autowired
//    private MapperFactoryBean<CustomerMapper> factoryBean;

    @Test
    public void testSqlSessionFactory() {
        try (SqlSession sqlSession = factory.openSession()) {
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = mapper.getCustomerById(1l);
            System.out.println(customer);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void mapperFactoryTest() throws Exception {
//        CustomerMapper mapper = factoryBean.getObject();
//        System.out.println(mapper.getCustomerById(1l));
//    }
}
