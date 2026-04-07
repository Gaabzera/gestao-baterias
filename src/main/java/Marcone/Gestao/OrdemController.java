package Marcone.Gestao;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ordens")
@CrossOrigin(origins = "*")
public class OrdemController {

    private final OrdemService service;

    public OrdemController(OrdemService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrdemDeServico> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public OrdemDeServico criar(@RequestBody OrdemDeServico ordem) {
        return service.criar(ordem);
    }

    @PutMapping("/{id}/status")
    public OrdemDeServico atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }
}