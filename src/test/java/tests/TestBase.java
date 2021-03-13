package tests;

import org.junit.jupiter.api.BeforeAll;

import static helpers.DriverHelper.configureDriver;

public class TestBase {
    @BeforeAll
    public static void beforeAll(){
        configureDriver();

    }
}
