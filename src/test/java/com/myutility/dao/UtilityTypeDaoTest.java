package com.myutility.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myutility.model.UtilityType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilityTypeDaoTest {

  @Autowired
  private UtilityTypeDao utilityTypeDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testFindAllUtiityTypes() {

    List<UtilityType> utilityTypes = utilityTypeDao.findAll();

    assertThat(utilityTypes.isEmpty(), is(false));

  }
}
