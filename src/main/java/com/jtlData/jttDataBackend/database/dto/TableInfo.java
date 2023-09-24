package com.jtlData.jttDataBackend.database.dto;

import com.jtlData.jttDataBackend.database.entity.InfoColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class TableInfo {

    private String tableName;

    private List<InfoColumn> columns;
}
