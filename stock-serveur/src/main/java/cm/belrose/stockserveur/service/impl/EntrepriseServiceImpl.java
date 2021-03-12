package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.repository.EntrepriseRepository;
import cm.belrose.stockserveur.service.EntrepriseService;
import cm.belrose.stockserveur.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {


    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors= EntrepriseValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Entreprise non valide {}", dto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

    @Override
    public EntrepriseDto findById(Long id) {
        if(id==null){
            log.error("Entreprise ID is null");
            return null;
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune entreprise avec l'ID="+id+"n'a été trouvé dans la BD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Categorie CODE is null");
            return null;
        }
        return entrepriseRepository.findEntrepriseByNom(nom)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune entreprise avec le NOM = "+nom+" n'a été trouvé dans la BD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Entreprise ID is null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }

}
