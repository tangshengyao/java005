import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;
import com.offcn.dao.MobileDao;
import com.offcn.dao.StuDao;
import com.offcn.po.Mobile;
import com.offcn.po.Stu;

public class TestDao {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");

		/*StuDao dao = context.getBean(StuDao.class);
		//保存数据
		Stu s = new Stu();
		s.setName("测试");
		s.setScore(99.89F);
		
		dao.save(s);
		List<Stu> list = dao.getAll();
		for (Stu stu : list) {
			System.out.println(stu);
		}*/
		
		MobileDao dao = context.getBean(MobileDao.class);
		Mobile m = new Mobile();
		m.setAreacode("028");
		m.setMobilearea("四川 成都");
		m.setMobilenumber("1300002");
		m.setMobiletype("中国联通GSM");
		m.setPostcode("051000");
		
		Mobile m2 = new Mobile();
		m2.setAreacode("029");
		m2.setMobilearea("四川 都江堰");
		m2.setMobilenumber("1300008");
		m2.setMobiletype("中国移动GSM");
		m2.setPostcode("091000");
		List<Mobile> list=new ArrayList();
		list.add(m);
		list.add(m2);
		dao.saves(list);
	}

}
