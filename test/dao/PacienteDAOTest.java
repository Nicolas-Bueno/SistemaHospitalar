package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PacienteDAOTest {
    
    private PacienteDAO pacienteDao;
    
    public PacienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        pacienteDao = new PacienteDAO();    
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testar_CadastrarPaciente(){
        Date dataNascimento = new Date(2002, 02, 28);
        Paciente paciente = new Paciente(10, "Nome", "Endereco",dataNascimento, "telefone", "cpf", "rg", "email@", 1);
        try {
            pacienteDao.cadastrarPaciente(paciente);
            assertTrue(true);
            
        } catch (Exception e) {
            fail("Exceção SQL não deveria ter ocorrido: " + e.getMessage());
        }
    }
    
     @Test
    public void testBuscarPacientePorFiltro() {
        Date dataNascimento = new Date(2005, 8, 10);
        Paciente paciente2 = new Paciente(26, "Maria", "endereco2", dataNascimento, "222", "2222", "rg2", "email2", 2);

        // Cadastrar os pacientes para testar a busca
        try {
            pacienteDao.cadastrarPaciente(paciente2);
            assertTrue(true);
        } catch (SQLException e) {
            fail("Exceção SQL não deveria ter ocorrido ao cadastrar pacientes: " + e.getMessage());
        }

        // Tentar buscar o paciente
        try {
            List<Paciente> pacientes = pacienteDao.buscarPacienteFiltro("where CPF = '2222'");

            assertNotNull(pacientes);
            assertTrue(pacientes.size() > 0);
            assertEquals("2222",paciente2.getCpf());
            

        } catch (SQLException e) {
            fail("Exceção SQL não deveria ter ocorrido ao buscar o paciente: " + e.getMessage());
        }
    }
    
}
