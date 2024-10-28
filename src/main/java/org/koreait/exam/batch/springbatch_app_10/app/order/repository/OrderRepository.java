package org.koreait.exam.batch.springbatch_app_10.app.order.repository;

import org.koreait.exam.batch.springbatch_app_10.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
