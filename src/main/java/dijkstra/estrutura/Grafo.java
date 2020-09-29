package dijkstra.estrutura;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grafo {

    private Set<No> nos = new HashSet<>();

    public void adicionarNo(No no) {
        nos.add(no);
    }

    public Optional<No> encontrarNoPorNome(String nome) {
        String nomeSemAcentos = StringUtils.stripAccents(nome);

        return nos.stream()
                .filter(no -> StringUtils.stripAccents(no.getNome()).toLowerCase().equals(nomeSemAcentos.toLowerCase()))
                .findFirst();
    }
}
