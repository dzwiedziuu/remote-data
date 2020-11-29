package pl.dzwiedziuu.data.remote;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DataUnit {

    private String id;
    private String dataType;
    private String owner;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private String data;
}
