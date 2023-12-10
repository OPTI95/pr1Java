import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService {

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Implement currency conversion logic here
        // For simplicity, let's just return the same amount without conversion
        return amount;
    }
}
