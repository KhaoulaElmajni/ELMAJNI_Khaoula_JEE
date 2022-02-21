package ext;

import dao.IDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImplVWS implements IDao {
    @Override
    public double getData() {
        System.out.println("version : web service");
        return 90;
    }
}
