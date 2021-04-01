package spring.hexagonal.structure.demo.domain.core.users

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : PagingAndSortingRepository<User, Long> {
    @Query(
            value = "DELETE FROM users WHERE id = ?1",
            nativeQuery = true
    )
    fun removeByUUID(uuid: String);

    @Query(
            value = "SELECT * FROM users WHERE id = uuid(?1)",
            nativeQuery = true
    )
    fun findByUUID(uuid: String) : Optional<User>


    @Query(
            value = "SELECT * FROM users WHERE email like ?1",
            nativeQuery = true
    )
    fun findByEmail(email: String) : Optional<User>
}