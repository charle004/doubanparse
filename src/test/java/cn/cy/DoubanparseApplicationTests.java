package cn.cy;

import cn.cy.mapper.Top250Mapper;
import cn.cy.utils.GrabTop250;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class DoubanparseApplicationTests {

    @Resource
    private Top250Mapper top250Mapper;

    @Test
    void contextLoads() {
        GrabTop250.getTop250List().forEach(e->{top250Mapper.insert(e);});
    }

}
