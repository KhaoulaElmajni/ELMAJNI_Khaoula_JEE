package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        // v1 ==> DaoImpl dao = new DaoImpl();

        /*
        * injection de dependances par instanciation statique => new
        */
        DaoImpl2 dao = new DaoImpl2();

        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Resultat = "+metier.calcul());
    }
}
