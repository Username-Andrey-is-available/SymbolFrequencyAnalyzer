package ivanchinandrey.symbolfrequencyanalyzer.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FrequencyServiceTest {

    @Autowired
    private FrequencyService frequencyService;

    @Test
    void testCalculateFrequency() {
        String inputString = "aaaaabcccc";
        Map<Character, Long> result = frequencyService.calculateFrequency(inputString);

        assertNotNull(result);
        assertEquals(5, result.get('a'));
        assertEquals(4, result.get('c'));
        assertEquals(1, result.get('b'));

        // Проверка на убывающий порядок
        assertTrue(isDecreasingOrder(result));
    }

    @Test
    void testCalculateFrequencyWithEmptyString() {
        String inputString = "";
        assertThrows(IllegalArgumentException.class, () -> frequencyService.calculateFrequency(inputString));
    }

    @Test
    void testCalculateFrequencyWithNullString() {
        assertThrows(IllegalArgumentException.class, () -> frequencyService.calculateFrequency(null));
    }

    private boolean isDecreasingOrder(Map<Character, Long> result) {
        // Проверка, что значения частот идут в убывающем порядке
        return result.values()
                .stream()
                .toList()
                .equals(result.values()
                        .stream()
                        .sorted((o1, o2) -> Long.compare(o2, o1))
                        .collect(Collectors.toList()));
    }
}
