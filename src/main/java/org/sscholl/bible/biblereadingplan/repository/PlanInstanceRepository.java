package org.sscholl.bible.biblereadingplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sscholl.bible.biblereadingplan.model.PlanInstance;

/**
 * Created by Simon
 */
public interface PlanInstanceRepository extends JpaRepository<PlanInstance, Integer> {


}
