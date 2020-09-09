//package com.example.base;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.StopWatch;
//
//@SpringBootTest
//public class MysqlDemoApplicationTests {
//    @Autowired
//    private JdbcTemplateService jdbcTemplateService;
//
//    @Autowired
//    private AutoKeyTableService autoKeyTableService;
//
//    @Autowired
//    private UUIDKeyTableService uuidKeyTableService;
//
//    @Autowired
//    private RandomKeyTableService randomKeyTableService;
//
//    @Test
//    void testDBTime() {
//
//        StopWatch stopwatch = new StopWatch("执行sql时间消耗");
//
//        /**
//         * auto_increment key任务
//         */
//        final String insertSql = "INSERT INTO user_key_auto(user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?)";
//
//        List<UserKeyAuto> insertData = autoKeyTableService.getInsertData();
//        stopwatch.start("自动生成key表任务开始");
//        long start1 = System.currentTimeMillis();
//        if (CollectionUtil.isNotEmpty(insertData)) {
//            boolean insertResult = jdbcTemplateService.insert(insertSql, insertData, false);
//            System.out.println(insertResult);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("auto key消耗的时间:" + (end1 - start1));
//
//        stopwatch.stop();
//
//
//        /**
//         * uudID的key
//         */
//        final String insertSql2 = "INSERT INTO user_uuid(id,user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?,?)";
//
//        List<UserKeyUUID> insertData2 = uuidKeyTableService.getInsertData();
//        stopwatch.start("UUID的key表任务开始");
//        long begin = System.currentTimeMillis();
//        if (CollectionUtil.isNotEmpty(insertData)) {
//            boolean insertResult = jdbcTemplateService.insert(insertSql2, insertData2, true);
//            System.out.println(insertResult);
//        }
//        long over = System.currentTimeMillis();
//        System.out.println("UUID key消耗的时间:" + (over - begin));
//
//        stopwatch.stop();
//
//
//        /**
//         * 随机的long值key
//         */
//        final String insertSql3 = "INSERT INTO user_random_key(id,user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?,?)";
//        List<UserKeyRandom> insertData3 = randomKeyTableService.getInsertData();
//        stopwatch.start("随机的long值key表任务开始");
//        Long start = System.currentTimeMillis();
//        if (CollectionUtil.isNotEmpty(insertData)) {
//            boolean insertResult = jdbcTemplateService.insert(insertSql3, insertData3, true);
//            System.out.println(insertResult);
//        }
//        Long end = System.currentTimeMillis();
//        System.out.println("随机key任务消耗时间:" + (end - start));
//        stopwatch.stop();
//
//
//        String result = stopwatch.prettyPrint();
//        System.out.println(result);
//    }
//}
