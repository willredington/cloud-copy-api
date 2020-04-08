package com.willredington.service;

import com.willredington.dto.StringEvent;
import com.willredington.entity.CopyItem;
import java.util.List;

public interface CopyService {

  void save(StringEvent event);

  List<CopyItem> getAll();
}
