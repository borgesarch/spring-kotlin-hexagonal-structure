package spring.hexagonal.structure.demo.application.core.users

import spring.hexagonal.structure.demo.domain.core.users.User
import java.util.*

interface IUserService {
    fun findAll() : Iterable<User>
    fun findByUUID(user_id : String) : Optional<User>
    fun findByEmail(email: String) : Optional<User>
    fun save(user :User) : User
    fun update(user : User) : User
    fun removeByUUID(user_id : String)
}