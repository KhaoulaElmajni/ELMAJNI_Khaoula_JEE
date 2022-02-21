package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao") //==> remplace le <bean id="dao" class="dao.DaoImpl"></bean> dans la version xml
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
        * se connecter a la BD pour recuperre la temperature
        * */
        System.out.println("version BD");
        double temp = Math.random()*40;
        return temp;
    }

    public void init(){
        System.out.println("DaoImpl Instatnciation");
    }
}
