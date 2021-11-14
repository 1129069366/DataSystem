package com.system.DataSystem.dao;

import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 12:37
 **/
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
