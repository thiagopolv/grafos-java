package estrutura;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grafo {

    private Set<No> nos = new HashSet<>();

    public void adicionarNo(No no) {
        nos.add(no);
    }
}
