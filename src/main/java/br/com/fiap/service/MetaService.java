package br.com.fiap.service;

import br.com.fiap.dto.MetaDTO;
import br.com.fiap.model.Meta;
import br.com.fiap.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    private final MetaRepository repository;

    public MetaService(MetaRepository repository) {
        this.repository = repository;
    }

    public List<MetaDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public MetaDTO save(MetaDTO dto) {
        Meta meta = new Meta(null, dto.titulo(), dto.descricao(), dto.valor(), dto.dataLimite());
        return toDTO(repository.save(meta));
    }

    private MetaDTO toDTO(Meta meta) {
        return new MetaDTO(meta.getId(), meta.getTitulo(), meta.getDescricao(), meta.getValor(), meta.getDataLimite());
    }
}