package keeptalkingandnobodyexplodes.words;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PasswordSolver {

    private static final Set<String> words = Set.of("alarm", "apacz", "arena", "babka", "cecha", "ekipa",
            "fajka", "farma", "głowa", "hańba", "larwa", "laska", "macka", "obiad", "palec", "palma", "pegaz",
            "robak", "scena", "skrót", "smoła", "smycz", "tafla", "teren", "toast", "torba", "trasa", "twarz",
            "walka", "wełna", "wnęka", "zakaz", "zwiad", "znicz", "żniwa");

    public static List<Predicate<String>> parsePredicates(String inputParameters) {
        List<Predicate<String>> predicates = new ArrayList<>();

        for (String lettersOnPosition : inputParameters.split(" ")) {
            int position = getPosition(lettersOnPosition);
            Set<Character> letters = getLetters(lettersOnPosition);

            predicates.add(p -> letters.contains(p.charAt(position)));
        }

        return predicates;
    }

    private static Set<Character> getLetters(String lettersOnPosition) {
        String letters = lettersOnPosition.split(":")[1];
        return letters.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    private static int getPosition(String lettersOnPosition) {
        String position = lettersOnPosition.split(":")[0];
        return Integer.parseInt(position) - 1;
    }

    public static List<String> solve(String parameters) {
        List<Predicate<String>> predicates = parsePredicates(parameters);
        return collectFittingPasswords(predicates);
    }

    private static List<String> collectFittingPasswords(List<Predicate<String>> predicates) {
        return words.stream()
                .filter(word -> fitsPredicates(predicates, word))
                .collect(Collectors.toList());
    }

    private static boolean fitsPredicates(List<Predicate<String>> predicates, String word) {
        return predicates.stream()
                .allMatch(t -> t.test(word));
    }
}
