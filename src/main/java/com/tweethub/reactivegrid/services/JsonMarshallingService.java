package com.tweethub.reactivegrid.services;

import java.util.List;
import java.util.Map;

public interface JsonMarshallingService {
  public <T> Map<String, T> convertListToSequencedMap(List<T> list);
}
