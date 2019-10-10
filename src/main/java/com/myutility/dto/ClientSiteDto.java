package com.myutility.dto;

import lombok.Data;

@Data
public class ClientSiteDto {

  private Long clientId;
  private String postcode;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String addressLine4;
}
