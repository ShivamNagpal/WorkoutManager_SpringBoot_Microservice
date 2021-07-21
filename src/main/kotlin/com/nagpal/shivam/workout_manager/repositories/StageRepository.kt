package com.nagpal.shivam.workout_manager.repositories

import com.nagpal.shivam.workout_manager.models.Stage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface StageRepository : CrudRepository<Stage, Long> {
    @Query(value = "select max(s.order) from Stage s where s.program.id = :programId")
    fun fetchMaxCount(programId: Long): Optional<Int>
    fun findByIdAndDeleted(id: Long, deleted: Boolean = false): Optional<Stage>
    fun findAllByDeleted(pageable: Pageable, deleted: Boolean = false): List<Stage>
}
