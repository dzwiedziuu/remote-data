package pl.dzwiedziuu.data.remote.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import pl.dzwiedziuu.data.remote.DataUnit;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dataUnit")
@EntityListeners(AuditingEntityListener.class)
public class DataUnitWrapper extends DataUnit {

    public DataUnitWrapper() {
    }

    public DataUnitWrapper(DataUnit dataUnit) {
        setId(dataUnit.getId());
        setDataType(dataUnit.getDataType());
        setOwner(dataUnit.getOwner());
        setInsertTime(dataUnit.getInsertTime());
        setUpdateTime(dataUnit.getUpdateTime());
        setData(dataUnit.getData());
    }

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getDataType() {
        return super.getDataType();
    }

    @Override
    public String getOwner() {
        return super.getOwner();
    }

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(updatable = false)
    @Override
    public LocalDateTime getInsertTime() {
        return super.getInsertTime();
    }

    @LastModifiedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Override
    public LocalDateTime getUpdateTime() {
        return super.getUpdateTime();
    }

    @Lob
    @Override
    public String getData() {
        return super.getData();
    }
}
