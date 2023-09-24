package com.jtlData.jttDataBackend.controller;

import com.jtlData.jttDataBackend.database.dto.TableInfo;
import com.jtlData.jttDataBackend.database.entity.InfoColumn;
import com.jtlData.jttDataBackend.database.repository.InfoColumnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InfoColumnController {
    final InfoColumnRepository infoColumnRepository;

    @GetMapping("/infoColumn")
    @CrossOrigin
    private List<InfoColumn> getAllInfoColumn(){
        return infoColumnRepository.findAll();
    }
    @GetMapping("/infoColumn/tableName/{tableName}")
    @CrossOrigin
    private List<InfoColumn> getAllInfoColumnFilterTableName(@PathVariable String tableName){
        return infoColumnRepository.findByTableName(tableName);
    }

    @GetMapping("/infoColumn/table/{tableName}/column/{columnName}")
    @CrossOrigin
    private List<TableInfo> getAllInfoColumnFilterTableAndColumn(@PathVariable String tableName, @PathVariable String columnName){
        List<TableInfo> tableList =  new ArrayList<>();
        for ( String table  : infoColumnRepository.findDistinctTableByTableNameAndColumnName(tableName, columnName)  ) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(table);
            tableInfo.setColumns(infoColumnRepository.findByTableName(table));

            tableList.add(tableInfo);
        }
        return tableList;
    }

}
