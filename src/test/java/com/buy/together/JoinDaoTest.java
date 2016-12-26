package com.buy.together;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.JoinDao;
import com.buy.together.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JoinDaoTest {
   
   /*SHA256 sha = SHA256.getInsatnce();*/
   
   @Inject
   JoinDao joinDao;
   
   @Test
   public void testJoin() throws Exception {
      
      User user = new User();
      
      user.setId("user01");
      user.setPw("u01");
      user.setName("김권식");
      user.setNickname("김권식쨩");
      String from = "1992-04-18";
      SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date to = transFormat.parse(from);
      user.setBirthdate(to);
      user.setGender("M");
      user.setPhone_number("01029744318");
      user.setEmail("slsrmsn@hhhh.com");

     /* String orgPass = user.getPw();
       String shaPass = sha.getSha256(orgPass.getBytes());
      
      user.setPw(shaPass);*/
      
      joinDao.create(user);
      
   }

}