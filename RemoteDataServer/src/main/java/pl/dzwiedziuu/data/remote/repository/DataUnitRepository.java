package pl.dzwiedziuu.data.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.dzwiedziuu.data.remote.model.DataUnitWrapper;


@Repository
public interface DataUnitRepository extends JpaRepository<DataUnitWrapper, String>, JpaSpecificationExecutor<DataUnitWrapper> {
}
