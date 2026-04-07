package Marcone.Gestao;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdemService {

    private final OrdemRepository repository;

    public OrdemService(OrdemRepository repository) {
        this.repository = repository;
    }

    public List<OrdemDeServico> listarTodas() {
        return repository.findAll();
    }

    public OrdemDeServico criar(OrdemDeServico ordem) {
        return repository.save(ordem);
    }

    public OrdemDeServico atualizarStatus(Long id, String novoStatus) {
        OrdemDeServico ordem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));
        ordem.setStatus(StatusOrdem.valueOf(novoStatus));
        return repository.save(ordem);
    }
}