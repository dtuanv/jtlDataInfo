package com.jtlData.jttDataBackend.database.repository;

import com.jtlData.jttDataBackend.database.entity.InfoColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface InfoColumnRepository extends JpaRepository<InfoColumn, Long> {
    @Query(value="SELECT * FROM info_column WHERE table_name ILIKE %?1%", nativeQuery = true)
    List<InfoColumn> findByTableName (String tableName);

    @Query(value="SELECT * FROM info_column WHERE table_name ILIKE %?1% AND column_name ILIKE %?2%", nativeQuery = true)
    List<InfoColumn> findByTableNameAndColumnName (String tableName, String columnName);

    @Query(value="SELECT DISTINCT(table_name) FROM info_column WHERE table_name ILIKE %?1% AND column_name ILIKE %?2%", nativeQuery = true)
    List<String> findDistinctTableByTableNameAndColumnName (String tableName, String columnName);


}
