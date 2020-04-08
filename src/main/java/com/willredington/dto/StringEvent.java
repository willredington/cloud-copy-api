package com.willredington.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StringEvent {

  private UUID uuid;

  private Long created;

  private String payload;
}
