package com.longjw.demo;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.longjw.demo.bean.Users;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;
import com.longjw.demo.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationDemoTest {

    @Autowired
    private UserDao userDao;

    private Users users;

    @Before
    public void before() {
        users = new Users();
    }

    @Test
    public void insertTest() {
        users.setCreateTime(new Date());
        users.setUserIp("168.0.0.1");
        users.setUserName("张三");
        userDao.save(users);
    }

    @Test
    public void insertTest2() {
        for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setCreateTime(new Date());
            users.setUserIp("127.0.0.1");
            users.setUserName(getStringRandom(10));
            userDao.save(users);
        }
    }


    @Test
    public void update() {

        users.setId(2);
        users.setUserName("里斯");
        users.setUserIp("192.168.0.1");
        users.setCreateTime(new Date());
        userDao.save(users);
    }

    @Test
    public void select2() {
        List<Users> result = userDao.findByUserName("张三");
        System.out.println(result);
    }

    @Test
    public void select3() {
        List<Users> result = userDao.findByUserNameAndUserIp("张三", "168.0.0.1");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = new PageRequest(0, 8);
        Page<Users> result = userDao.findAll(pageable);
        System.out.println(result.getContent());
    }


    @Test
    public void delete() {
        userDao.delete(1);
    }


    //生成随机数字和字母,
    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    @Test
    public void testRandom() {
        System.out.println(getStringRandom(10));
    }


}
