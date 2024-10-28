package org.koreait.exam.batch.springbatch_app_10.app.cash.repository;

import org.koreait.exam.batch.springbatch_app_10.app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<CashLog, Long> {
}
