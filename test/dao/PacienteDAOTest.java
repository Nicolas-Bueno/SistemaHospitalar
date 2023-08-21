package dao;

import java.sql.SQLException;
import java.util.Date;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
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
        Paciente paciente = new Paciente(10, "Nome", "Endereco",dataNascimento, "teledone", "cpf", "rg", "email@", 1);
        try {
            pacienteDao.cadastrarPaciente(paciente);
            assertTrue(true);
            
        } catch (Exception e) {
            fail("Exceção SQL não deveria ter ocorrido: " + e.getMessage());
        }
    }

    
    
}
