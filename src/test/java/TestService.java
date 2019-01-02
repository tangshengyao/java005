import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Mobile;
import com.offcn.po.Stu;
import com.offcn.service.MobileService;
import com.offcn.service.StuService;

public class TestService {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");

		/*StuService service = context.getBean(StuService.class);
		
		List<Stu> list = service.getAll();
		for (Stu stu : list) {
			System.out.println(stu);
		}*/
		MobileService service = context.getBean(MobileService.class);
		Mobile m = new Mobile();
		m.setAreacode("028");
		m.setMobilearea("四川 成都");
		m.setMobilenumber("1300002");
		m.setMobiletype("中国联通GSM");
		m.setPostcode("051000");
		service.save(m);
	}

}
