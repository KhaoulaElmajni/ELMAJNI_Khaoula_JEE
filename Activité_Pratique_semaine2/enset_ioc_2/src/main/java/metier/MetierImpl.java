package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier{
    //couplage faible

    @Autowired
    private IDao dao=null;

    @Override
    public double calcul() {
        double temp = dao.getData();//n'importe quel source:classe
        double res=temp*540/Math.cos(temp*Math.PI);
        return res;
    }

    //permet d'injecter dans la variable dao un obj d'une classe qui implemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
        System.out.println("injections des dependances");
    }

    public void init(){
        System.out.println("MetierImpl Initialisation");
    }

    public MetierImpl() {
        System.out.println("MetierImpl Instantiation");
    }
}
