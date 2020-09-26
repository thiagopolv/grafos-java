package estrutura;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class No {

    private String nome;
    private LinkedList<No> caminhoMaisCurto = new LinkedList<>();
    private Integer distancia = Integer.MAX_VALUE;
    private Map<No, Integer> nosAdjacentes = new HashMap<>();

    public No(String nome) {
        this.nome = nome;
    }

    public void adicionarDestino(No destino, int distancia) {
        nosAdjacentes.put(destino, distancia);
    }

    public String caminhoMaisCurtoToString() {
        StringBuilder string = new StringBuilder();
        string.append("Caminho mais curto de ").append(caminhoMaisCurto.get(0).getNome()).append(" até ")
                .append(getNome()).append(":").append(System.lineSeparator());

        for (No no: caminhoMaisCurto) {
            if (no.equals(caminhoMaisCurto.getLast())) {
                string.append(no.getNome()).append(" -> ").append(getNome());
            } else {
                string.append(no.getNome()).append(" -> ");
            }
        }

        string.append(System.lineSeparator()).append("Distância: ").append(distancia);

       return string.toString();
    }
}
