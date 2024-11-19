import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefone {
    private String numero;

    // Construtor
    public Telefone(String numero) {
        if (!validarTelefone(numero)) {
            throw new IllegalArgumentException("Telefone inválido. O formato deve ser XX XXXXX-XXXX.");
        }
        this.numero = numero;
    }

    // Método para validar o telefone
    public static boolean validarTelefone(String numero) {
        String regex = "^\\d{2} \\d{5}-\\d{4}$";  // Formato: XX XXXXX-XXXX
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    // Método para obter o número de telefone
    public String getNumero() {
        return numero;
    }

    // Método para formatar o número de telefone (caso seja necessário)
    public String formatarTelefone() {
        return numero.replace(" ", "").replace("-", "");
    }

    // Override do toString para exibir o telefone de forma amigável
    @Override
    public String toString() {
        return this.numero;
    }

    // Método para definir o número de telefone
    public void setNumero(String numero) {
        if (!validarTelefone(numero)) {
            throw new IllegalArgumentException("Telefone inválido. O formato deve ser XX XXXXX-XXXX.");
        }
        this.numero = numero;
    }
}
