package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresAvecSpringAnnotations {
    public static void main(String[] args) {
        //je le donne les packages à scanner ==> ou il se trouve les annotations @Component
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ext","metier");

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
