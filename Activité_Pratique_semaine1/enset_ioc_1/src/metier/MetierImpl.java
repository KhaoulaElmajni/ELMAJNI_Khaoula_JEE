package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    //couplage faible
    private IDao dao;

    @Override
    public double calcul() {
        double temp = dao.getData();//n'importe quel source:classe
        double res=temp*540/Math.cos(temp*Math.PI);
        return res;
    }

    //permet d'injecter dans la variable dao un obj d'une classe qui implemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
