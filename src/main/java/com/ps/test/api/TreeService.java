package com.ps.test.api;

import com.ps.test.datamodel.Tree;
import com.ps.test.dto.GroupedCount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// package minuscule  class majiscule

@Service
public class TreeService
{
  @Autowired
  private TreeRepository repository;
  
  public List<Tree> getAllTrees()
  {
    return repository.getAllTrees();
  }
  
  public List<GroupedCount> getTreeCountByDistrict()
  {
    return repository.getTreeCountByDistrict();
  }
  
  public List<GroupedCount> getTreeCountByGenre()
  {
    return repository.getTreeCountByGenre();
  }
}
