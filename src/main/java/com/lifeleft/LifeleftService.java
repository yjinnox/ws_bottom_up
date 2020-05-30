package com.lifeleft;

import exceptions.LifeLeftException;
import exceptions.LifeLeftFault;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

@WebService(serviceName = "LifeLeft")
public class LifeleftService {
    private static  final Integer ESPERANCE_VIE_HOMMES = 79;
    private static  final Integer ESPERANCE_VIE_FEMMES = 85;

    String homme = "HOMME";
    String femme = "FEMME";

    Integer evDeReference = 0;

    @WebMethod
    public  String anneesRestantesAVivre(String prenom, String genre,Integer anneeNaissance) throws LifeLeftException {
        //vaut mieux remplacer 2017 par Year.now().getValue(), mais pour simplifier on laisse 2017
        if(anneeNaissance > 2017) {

            //On créer une nouvelle instance de notre POJO
            LifeLeftFault fault = new LifeLeftFault();

            //On y ajoute le code d'erreur et le détail de l'erreur en question
            fault.setFaultCode("1234");
            fault.setFaultString("L'année reçu est supérieur l'année actuelle");

            //on lance l'exception avec comme premier argument un message général sur l'erreur.
            throw new LifeLeftException("Année invalide", fault);
        }

        if(genre.equals(homme)) evDeReference = ESPERANCE_VIE_HOMMES;
        else evDeReference = ESPERANCE_VIE_FEMMES;

        //Remarque, en cas de problème, vous pouvez changer Year.now().getValue() par Calendar.getInstance().get(Calendar.YEAR)
        Integer anneeRestantes = evDeReference -(Year.now().getValue() - anneeNaissance );



        return "Bonjour " + prenom + ", il vous reste " + anneeRestantes + " ans, à vivre, Profitez-en au maximum !";
    }

    @WebMethod
    public int creerClient(String login, String password){

        return ThreadLocalRandom.current().nextInt(100, 900);
    }

    @WebMethod
    public String commanderCompteARebour(Integer clientId) {

        return "Merci ! Votre commande pour le client: "+ clientId + " de compteur de vie est validée";

    }
}
