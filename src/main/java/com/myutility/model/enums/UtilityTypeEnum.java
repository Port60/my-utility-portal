package com.myutility.model.enums;

public enum UtilityTypeEnum {

  GAS(new Long(1), "GAS"), ELECTRIC(new Long(2), "ELECTRIC");

  private Long id;
  private String name;

  private UtilityTypeEnum(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
