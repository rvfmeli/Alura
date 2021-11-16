package controller;

package br.com.meli.desafiospring.model.service;

import br.com.meli.desafiospring.exception.ValidaEntradaException;
import br.com.meli.desafiospring.model.dao.ProprietarioDAO;
import br.com.meli.desafiospring.model.dto.ProprietarioDTO;
import br.com.meli.desafiospring.model.entity.Consulta;
import br.com.meli.desafiospring.model.entity.Proprietario;
import br.com.meli.desafiospring.model.repository.ProprietarioRepository;
import br.com.meli.desafiospring.util.ConvesorUtil;
import br.com.meli.desafiospring.util.FormatdorUtil;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

    @Getter
    private static final List<Proprietario> listaProprietario = new ArrayList<>();
    private ProprietarioDAO proprietarioDAO;
    private final ConvesorUtil convesorUtil = new ConvesorUtil();
    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioDAO proprietarioDAO, ProprietarioRepository proprietarioRepository) {
        this.proprietarioDAO = proprietarioDAO;
        this.proprietarioRepository = proprietarioRepository;
    }


    public Integer cadastrar(ProprietarioDTO proprietarioDTO) {
        Proprietario proprietario = (Proprietario) convesorUtil.conveterDTO(proprietarioDTO, Proprietario.class);
//        int tamanho=0;
//        if (!listaProprietario.isEmpty())
//            tamanho = listaProprietario.size() + 1;
//
//        for (Proprietario p : listaProprietario) {
//            tamanho = (p.getId());
//        }
////        proprietario.setId(tamanho + 1);
        listaProprietario.add(proprietario);
        proprietarioDAO.inserir(listaProprietario);
        return proprietario.getId();
    }

    public void validaEntradaProprietario(ProprietarioDTO proprietarioDTO) {
        if (validaGenerico("CPF", proprietarioDTO.getCpf())) {
            String cpf = FormatdorUtil.formatarCPF(proprietarioDTO.getCpf());
            for (int i = 0; i < listaProprietario.size(); i++) {
                if (listaProprietario.get(i).getCpf().equals(cpf)) {
                    throw new ValidaEntradaException("Proprietario ja existente!");
                }
            }
        }
        validaGenerico("Nome", proprietarioDTO.getNome());
        validaGenerico("Sobrenome", proprietarioDTO.getSobreNome());
        validaGenerico("Data Nascimento", proprietarioDTO.getDataNascimento());
        validaGenerico("Endereço", proprietarioDTO.getEndereco());
        validaGenerico("Telefone", proprietarioDTO.getTelefone()); }

    public boolean validaGenerico(String tipo, Object generico) {
        if (((tipo.equals("Telefone"))&&(Integer.parseInt(generico.toString())==0))||(ObjectUtils.isEmpty(generico))) {
            throw new ValidaEntradaException(tipo + " nao informando!!! Por gentileza informar.");
        }else {
            return true;
        }
    }

    public ProprietarioDTO editar(ProprietarioDTO proprietarioDTO, Integer id) {
        Optional<Proprietario> optionalProprietario = listaProprietario.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        Proprietario proprietario = optionalProprietario.orElse(null);
        Proprietario proprietario1 = new Proprietario();
        assert proprietario != null;
        proprietario.setCpf(proprietarioDTO.getCpf());
        proprietario.setNome(proprietarioDTO.getNome());
        proprietario.setSobreNome(proprietarioDTO.getSobreNome());
        proprietario.setDataNascimento(proprietario.getDataNascimento());
        proprietario.setEndereco(proprietario.getEndereco());
        proprietario.setTelefone(proprietario.getTelefone());
        proprietarioDAO.inserir(listaProprietario);
        return (ProprietarioDTO) convesorUtil.conveterDTO(proprietario, ProprietarioDTO.class);
    }


    public ProprietarioDTO excluir(Integer id) {
        ProprietarioDTO propritarioDTO = new ProprietarioDTO();
        for (int i = 0; i < listaProprietario.size(); i++)
            if(listaProprietario.get(i).getId().equals(id))
                if(verificarConsulta(listaProprietario.get(i)))
                    throw new ValidaEntradaException("Proprietario tem uma consulta!!! Nao e possivel excluir");
                else
                    listaProprietario.remove(listaProprietario.get(i));

        proprietarioDAO.inserir(listaProprietario);

        return propritarioDTO;
    }
    public Proprietario buscarProprietario(Integer id) {
//        Optional<Proprietario> optionalProprietario = listaProprietario.stream()
//                .filter(c -> c.getId().equals(id))
//                .findFirst();
//        return optionalProprietario.orElse(null);
        Optional<Proprietario> proprietario = proprietarioRepository.findById(id);
        if (proprietario.isPresent()) {
            return proprietario.get();
        } else {
            throw new ValidaEntradaException("Propritario inexistente, por gentileza enviar um valido!!!");
        }
    }

    public static boolean verificarConsulta(Proprietario proprietario) {
        for (Consulta c : ConsultaService.getListaConsulta())
            if (c.getPaciente().getProprietario().equals(proprietario))
                return true;
        return false;
    }
}
