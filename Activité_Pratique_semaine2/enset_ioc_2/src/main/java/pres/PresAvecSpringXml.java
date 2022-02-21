package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringXml {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //load un bean qui a comme id "metier"
        //IMetier metier = (IMetier) ctx.getBean("metier");
        IMetier metier =  ctx.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
