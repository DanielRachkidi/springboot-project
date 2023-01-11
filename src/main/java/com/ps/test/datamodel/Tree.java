package com.ps.test.datamodel;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tree", schema = "public")
@Getter
@Setter
@Access(AccessType.FIELD)
public class Tree
{
  @Id
  @Column(name = "idbase")
  private int idBase;
  
  @Column(name = "type_emplacement")
  private String typeEmplacement;
  
  @Column(name = "domanialite")
  private String domanialite;
  
  @Column(name = "arrondissement")
  private String arrondissement;
  
  @Column(name = "complement_adress")
  private String complementAdress;
  
  @Column(name = "numero")
  private String numero;
  
  @Column(name = "address")
  private String address;
  
  @Column(name = "idemplacement")
  private String idEmplacement;
  
  @Column(name = "libell_francais")
  private String libellFrancais;
  
  @Column(name = "genre")
  private String genre;
  
  @Column(name = "espece")
  private String espece;
}
