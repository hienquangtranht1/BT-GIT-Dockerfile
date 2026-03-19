package com.example.TranQuangHien2280600922.repository;

import com.example.TranQuangHien2280600922.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Chỉ lấy các kỹ năng chưa bị xóa (isDeleted = false)
    List<Skill> findByIsDeletedFalse();
}
