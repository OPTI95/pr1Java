import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {

    private final CalculatorService calculatorService;
    private final CurrencyConverterService currencyConverterService;

    @Autowired
    public AppController(CalculatorService calculatorService, CurrencyConverterService currencyConverterService) {
        this.calculatorService = calculatorService;
        this.currencyConverterService = currencyConverterService;
    }

}
