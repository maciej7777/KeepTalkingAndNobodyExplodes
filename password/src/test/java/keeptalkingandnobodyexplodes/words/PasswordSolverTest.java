package keeptalkingandnobodyexplodes.words;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class PasswordSolverTest {

    @DataProvider
    public static Object[][] inputQueryAndExpectedOutput() {
        return new Object[][]{
                {"1:ce 2:ae", Set.of("cecha")},
                {"2:ae 1:ce", Set.of("cecha")},
                {"1:ce 3:cz", Set.of("cecha")},
                {"1:wx 2:ez, 3:ł", Set.of("wełna")},
                {"1:a 2:pl", Set.of("apacz", "alarm")},
                {"1:x 2:z", Set.of()},
        };
    }

    @Test(dataProvider = "inputQueryAndExpectedOutput")
    public void testSolve(String input, Set<String> expectedOutput) {
        assertEquals(PasswordSolver.solve(input), expectedOutput);
    }
}