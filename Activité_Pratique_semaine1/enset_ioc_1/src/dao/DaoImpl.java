package dao;

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
}
