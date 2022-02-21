package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception{
        /*
        l'instanciation se fait en 2 :
                                        1- statique
                                        2- dynamique
         */
        //FileNotFoundException, ClassNotFoundException,
        //            InstantiationException, IllegalAccessException
        //ClassCastException ===> lorsque la classe n'implemente pas l'interface iDao
        Scanner reader = new Scanner(new File("config.txt"));
        String daoClassName = reader.next();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = reader.next();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao);



        System.out.println("Resultat = "+metier.calcul());
    }
}
