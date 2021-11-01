package keeptalkingandnobodyexplodes.words;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PasswordSolverTest {


    @DataProvider
    public static Object[][] inputQueryAndExpectedOutput() {
        return new Object[][]{
                {"1:ce 2:ae", List.of("cecha")},
                {"1:wx 2:ez, 3:ł", List.of("wełna")},
                {"1:a 2:pl", List.of("apacz", "alarm")},
        };
    }


    @Test(dataProvider = "inputQueryAndExpectedOutput")
    public void testSolve(String input, List<String> expectedOutput) {
        assertEquals(PasswordSolver.solve(input), expectedOutput);
    }
}