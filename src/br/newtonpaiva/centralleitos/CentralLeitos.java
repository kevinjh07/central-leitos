package br.newtonpaiva.centralleitos;

import br.newtonpaiva.centralleitos.models.Leito;
import br.newtonpaiva.centralleitos.models.Ocupacao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CentralLeitos {

    private static final String PERSISTENCE_UNIT_NAME = "CentralLeitosPU";

    private static final String NOME_ALA = "CTI";

    public static void main(String[] args) {
        final EntityManager em = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();

        em.getTransaction().begin();

        final Leito leito = new Leito();
        leito.setAla(NOME_ALA);

        final Ocupacao ocupacao = new Ocupacao();
        ocupacao.setDataEntrada(Calendar.getInstance());
        ocupacao.setDataSaida(Calendar.getInstance());
        ocupacao.setLeito(leito);

        em.persist(leito);
        em.persist(ocupacao);

        em.getTransaction().commit();

        em.close();
    }

}
