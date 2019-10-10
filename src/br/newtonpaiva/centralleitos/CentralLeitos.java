package br.newtonpaiva.centralleitos;

import br.newtonpaiva.centralleitos.models.Leito;
import br.newtonpaiva.centralleitos.models.Ocupacao;
import br.newtonpaiva.centralleitos.models.Paciente;
import br.newtonpaiva.centralleitos.models.enums.Sexo;
import br.newtonpaiva.centralleitos.models.enums.TipoSanguineo;
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

        final Leito leito = buildLeito();
        final Ocupacao ocupacao = buildOcupacao();
        ocupacao.setLeito(leito);

        final Paciente paciente = buildPaciente();

        em.persist(leito);
        em.persist(ocupacao);
        em.persist(paciente);

        em.getTransaction().commit();

        em.close();
    }

    private static Leito buildLeito() {
        final Leito leito = new Leito();
        leito.setAla(NOME_ALA);

        return leito;
    }

    private static Ocupacao buildOcupacao() {
        final Ocupacao ocupacao = new Ocupacao();
        ocupacao.setDataEntrada(Calendar.getInstance());
        ocupacao.setDataSaida(Calendar.getInstance());
        
        return ocupacao;
    }

    private static Paciente buildPaciente() {
        final Paciente paciente = new Paciente();
        paciente.setAltura(1.7);
        paciente.setCpf("82668435288");
        paciente.setDataNascimento(Calendar.getInstance());
        paciente.setDocumento("12345");
        paciente.setEmail("teste@teste.com");
        paciente.setNome("Teste");
        paciente.setPeso(70.0);
        paciente.setSexo(Sexo.M);
        paciente.setTipoSanguineo(TipoSanguineo.A_POSITIVO);

        return paciente;
    }

}
