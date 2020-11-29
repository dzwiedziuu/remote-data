package pl.dzwiedziuu.data.remote;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DataUnitQuery {

    private String id;
    private String dataType;
    private String owner;
    private LocalDateTime minInsertTime;
    private LocalDateTime minUpdateTime;
}
