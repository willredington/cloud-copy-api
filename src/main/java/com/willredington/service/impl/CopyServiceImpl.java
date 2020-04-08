package com.willredington.service.impl;

import com.willredington.dto.StringEvent;
import com.willredington.entity.CopyItem;
import com.willredington.service.CopyService;
import java.time.Instant;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class CopyServiceImpl implements CopyService {

  private final EntityManager em;

  @Inject
  public CopyServiceImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  @Transactional
  public void save(StringEvent event) {
    long now = Instant.now().getEpochSecond();
    em.persist(CopyItem.builder().created(now).updated(now).value(event.getPayload()).build());
  }

  @Override
  @Transactional
  public List<CopyItem> getAll() {
    return em.createQuery("select c from CopyItem c", CopyItem.class).getResultList();
  }
}
