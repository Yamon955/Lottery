package com.lottery.test.dao;

import com.alibaba.fastjson.JSON;
import com.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.lottery.infrastructure.po.UserTakeActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description 测试用户领取活动表，测试分库
 * @Author Yamon
 * @Create 2023/12/29 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {

    private Logger logger = LoggerFactory.getLogger(UserTakeActivityDaoTest.class);

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        //userTakeActivity.setuId("Uhdgkw766120d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setuId("Ukdli109op89oi"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        //userTakeActivity.setuId("Ukdli109op811d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d

        //userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setTakeId(121019889411L);
        //userTakeActivity.setTakeId(121019889412L);

        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);

        //userTakeActivity.setUuid("Uhdgkw766120d");
        userTakeActivity.setUuid("Uhdgkw766120e");
        //userTakeActivity.setUuid("Uhdgkw766120f");

        userTakeActivityDao.insert(userTakeActivity);
    }

    @Test
    public void test_select(){
        UserTakeActivity userTakeActivity = userTakeActivityDao.queryUserTakeActivityByUId("Ukdli109op89oi");
        logger.info("测试结果：{}", JSON.toJSONString(userTakeActivity));
    }

}
