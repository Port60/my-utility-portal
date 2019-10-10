package com.myutility.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@SequenceGenerator(name = "seq", sequenceName = "CLIENT_SITE_SEQ", allocationSize = 1)
public class ClientSite extends Item {

  @Id
  @GeneratedValue(generator = "seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "CLIENT_ID", nullable = false)
  private Client client;

  @Column(name = "POSTCODE")
  private String postcode;
  @Column(name = "ADDRESS_LINE_1")
  private String addressLine1;
  @Column(name = "ADDRESS_LINE_2")
  private String addressLine2;
  @Column(name = "ADDRESS_LINE_3")
  private String addressLine3;
  @Column(name = "ADDRESS_LINE_4")
  private String addressLine4;

}
