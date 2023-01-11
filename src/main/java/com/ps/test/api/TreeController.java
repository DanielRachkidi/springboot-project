package com.ps.test.api;

import com.ps.test.datamodel.Tree;
import com.ps.test.dto.GroupedCount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("tree")
public class TreeController
{
  
  @Autowired
  private TreeService service;
  
  @GetMapping("/trees")
  public List<Tree> getAllTrees()
  {
    return service.getAllTrees();
  }
  
  @GetMapping("/district/count")
  public List<GroupedCount> getTreeCountByDistrict()
  {
    return service.getTreeCountByDistrict();
  }
  
  @GetMapping("/genre/count")
  public List<GroupedCount> getTreeCountByGenre()
  {
    return service.getTreeCountByGenre();
  }
}
