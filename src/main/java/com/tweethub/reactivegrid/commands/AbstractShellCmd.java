package com.tweethub.reactivegrid.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tweethub.reactivegrid.services.impl.JsonMarshallingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractShellCmd {

  @Autowired
  protected JsonMarshallingServiceImpl jsonMarshallingService;

  protected ObjectMapper objectMapper;

  protected AbstractShellCmd() {
    objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }
}
