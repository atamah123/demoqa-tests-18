package examples;

import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Eto beforeAll");
    }

    @BeforeEach
     void beforeEach() {
        System.out.println("    Eto beforeEach");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("Eto AfterAll");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("    Eto AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("          Eto pervii test");
    }

    @Test
    void secondTest() {
        System.out.println("          Eto vtoroi test");
    }
}