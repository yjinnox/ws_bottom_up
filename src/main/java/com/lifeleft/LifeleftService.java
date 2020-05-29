package com.lifeleft;

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
    public  String anneesRestantesAVivre(String prenom, String sexe,Integer anneeNaissance){
        if(sexe.equals(homme)) {
            evDeReference = ESPERANCE_VIE_HOMMES;
        } else evDeReference = ESPERANCE_VIE_FEMMES;

        Integer anneesRestantes = evDeReference - (Year.now().getValue() - anneeNaissance);

        String valeurDeRetour = "Bonjour "+prenom+", il vous reste "+anneesRestantes+ "ans à vivre profitez-en au maximum.";

        return  valeurDeRetour;
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
