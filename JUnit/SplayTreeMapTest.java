/*
    Algoritmos y Estructura de Datos
    Hoja de Trabajo 9

    Integrantes:
    Alejandro Chaclan
    Jose Javier Jo
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SplayTreeMapTest {

    public SplayTreeMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

	//Para comprobar el funcionamiento del metodo put, primero se ingresa un dato al SplayTree y luego se busca
    @Test
    public void testPut() {
        System.out.println("put");
        SplayTreeMap<String, Association<String, String>> instance = new SplayTree<>();
        instance.put("yes", new Association<String, String>("yes", "si"));

        Association<String, String> expResult = new Association<>("yes", "si");
        Association<String, String> result = instance.get("yes");

        assertEquals(expResult, result);
    }

	//Para comprobar el funcionamiento del metodo put, primero se ingresa un dato al SplayTree y luego se comprueba que este
    @Test
    public void testGet() {
        System.out.println("get");
        SplayTreeMap<String, Association<String, String>> instance = new SplayTree<>();
        instance.put("homework", new Association<String, String>("homework", "tarea"));

        Association<String, String> expResult = new Association<>("homework", "tarea");
        Association<String, String> result = instance.get("homework");

        assertEquals(expResult, result);
    }
}
