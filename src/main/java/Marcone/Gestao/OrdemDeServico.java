package Marcone.Gestao;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placaVeiculo;
    private String nomeCliente;
    private String descricao;
    private String mecanicoResponsavel;

    @Enumerated(EnumType.STRING)
    private StatusOrdem status = StatusOrdem.A_FAZER;

    private LocalDate prazo;
    private LocalDateTime dataEntrada = LocalDateTime.now();
}

enum StatusOrdem {
    A_FAZER,
    EM_ANDAMENTO,
    CONCLUIDO
}