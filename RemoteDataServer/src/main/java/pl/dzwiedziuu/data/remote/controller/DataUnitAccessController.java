package pl.dzwiedziuu.data.remote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import pl.dzwiedziuu.data.remote.DataUnit;
import pl.dzwiedziuu.data.remote.DataUnitQuery;
import pl.dzwiedziuu.data.remote.model.DataUnitWrapper;
import pl.dzwiedziuu.data.remote.repository.DataUnitRepository;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@RestController
public class DataUnitAccessController {

    @Autowired
    private DataUnitRepository repository;

    @PostMapping("/register")
    @Transactional
    public void register(DataUnitWrapper dataUnitWrapper) {
        repository.save(dataUnitWrapper);
    }

    @GetMapping("/fetch")
    public List<? extends DataUnit> fetch(DataUnitQuery dataUnitQuery) {
        return repository.findAll(getSpecification(dataUnitQuery));
    }

    @PostMapping("/delete")
    @Transactional
    public void delete(DataUnitQuery dataUnitQuery) {
        repository.deleteAll(repository.findAll(getSpecification(dataUnitQuery)));
    }

    private Specification<DataUnitWrapper> getSpecification(DataUnitQuery dataUnitQuery) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new LinkedList<>();
            if(dataUnitQuery.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), dataUnitQuery.getId()));
            }
            if(dataUnitQuery.getDataType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dataType"), dataUnitQuery.getDataType()));
            }
            if(dataUnitQuery.getOwner() != null) {
                predicates.add(criteriaBuilder.equal(root.get("owner"), dataUnitQuery.getOwner()));
            }
            if(dataUnitQuery.getMinInsertTime() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("insertTime"), dataUnitQuery.getMinInsertTime()));
            }
            if(dataUnitQuery.getMinUpdateTime() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("updateTime"), dataUnitQuery.getMinUpdateTime()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}