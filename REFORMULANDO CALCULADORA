import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

enum Operacao {
    SOMA("+", "Soma", (a, b) -> a + b),
    SUBTRACAO("-", "Subtracao", (a, b) -> a - b),
    MULTIPLICACAO("*", "Multiplicacao", (a, b) -> a * b),
    DIVISAO("/", "Divisao", (a, b) -> {
        if (b == 0) throw new ArithmeticException("Divisao por zero invalida!");
        return a / b;
    }),
    POTENCIA("pow", "Elevacao (Potencia)", Math::pow),
    MODULO("%", "Resto da Divisao", (a, b) -> a % b),
    MEDIA("avg", "Media Aritmetica", (a, b) -> (a + b) / 2),
    FATORACAO("!", "Fatorial", (a, b) -> {
        if (a < 0 || a != Math.floor(a)) throw new ArithmeticException("Fatorial apenas para numeros inteiros nao-negativos!");
        return fatorial((int) a);
    });

    private final String simbolo;
    private final String descricao;
    private final BinaryOperator<Double> calculo;

   
    private static final Map<String, Operacao> MAPA_OPERATIVEIS = new HashMap<>();

    static {
        for (Operacao op : values()) {
            MAPA_OPERATIVEIS.put(op.simbolo, op);
        }
    }

    Operacao(String simbolo, String descricao, BinaryOperator<Double> calculo) {
        this.simbolo = simbolo;
        this.descricao = descricao;
        this.calculo = calculo;
    }

    public String getSimbolo() { return simbolo; }
    public String getDescricao() { return descricao; }

    public double calcular(double a, double b) {
        return calculo.apply(a, b);
    }

    public static Operacao porSimbolo(String simbolo) {
        return MAPA_OPERATIVEIS.get(simbolo);
    }
}

void main() {
    var historicoDeOperacoes = new ArrayList<String>();

    while (true) {
        IO.println("""
                Calculadora reformulada, digite .exit para sair, digite -h para ver o historico ou enter para continuar.
                """);
        var commando = IO.readln();

        if (commando.equals(".exit")) {
            System.exit(0);
        } else if (commando.equals("-h")) {
            IO.println("Historico: ");
            if (historicoDeOperacoes.isEmpty()) {
                IO.println("(Nenhuma operacao realizada)");
            } else {
                for (var operacao : historicoDeOperacoes) {
                    IO.println(operacao);
                }
            }
        } else if (commando.isEmpty()) {
            try {
                IO.println("Digite o primeiro numero:");
                var num1 = Double.parseDouble(IO.readln());

                IO.println("Digite o segundo numero:");
                var num2 = Double.parseDouble(IO.readln());

            
                IO.println("Digite a operacao desejada:");
                for (Operacao op : Operacao.values()) {
                    IO.println(op.getSimbolo() + " | " + op.getDescricao());
                }

                var entradaOp = IO.readln();
                Operacao op = Operacao.porSimbolo(entradaOp);

                if (op == null) {
                    IO.println("Operacao invalida!");
                    continue;
                }

                double resultado = op.calcular(num1, num2);
                
                String resultadoFormatado = (resultado % 1 == 0) 
                        ? String.valueOf((long) resultado) 
                        : String.valueOf(resultado);

                String registro = num1 + " " + op.getSimbolo() + " " + num2 + " = " + resultadoFormatado;
                
                IO.println("Resultado: " + resultadoFormatado);
                historicoDeOperacoes.add(registro);

            } catch (NumberFormatException e) {
                IO.println("Erro: Entrada numerica invalida.");
            } catch (ArithmeticException e) {
                IO.println("Erro: " + e.getMessage());
            }
        }
    }
}
