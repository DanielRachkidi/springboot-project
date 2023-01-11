package com.ps.test.api;

import com.ps.test.datamodel.Tree;
import com.ps.test.dto.GroupedCount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository
  extends JpaRepository<Tree, Integer>
{
  @Query(value = "select t from Tree t")
  List<Tree> getAllTrees();
  
  @Query(
    value = "select new com.ps.test.dto.GroupedCount(t.arrondissement, count(t)) " +
            "from Tree t group by t.arrondissement"
  )
  List<GroupedCount> getTreeCountByDistrict();
  
  @Query(
    value = "select new com.ps.test.dto.GroupedCount(t.genre, count(t)) " +
            "from Tree t group by t.genre"
  )
  List<GroupedCount> getTreeCountByGenre();
}
