import com.example.model.Speaker;
import com.example.repo.PassengerDao;
import com.example.repo.SpeakerRepo;
import com.example.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);

        PassengerDao pDao = appContext.getBean("passengerDao", PassengerDao.class);
        System.out.println(pDao.getPassenger(0).getId());

        System.out.println(service.findAll().get(0).getFirstName());

    }
}
