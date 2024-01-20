package ivanchinandrey.symbolfrequencyanalyzer.controller;

// Контроллер
import ivanchinandrey.symbolfrequencyanalyzer.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/frequency")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping
    public ResponseEntity<?> calculateFrequency(@RequestParam String inputString) {
        try {
            return ResponseEntity.ok(frequencyService.calculateFrequency(inputString));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
