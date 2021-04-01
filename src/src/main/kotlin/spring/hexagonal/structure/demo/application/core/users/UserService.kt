package spring.hexagonal.structure.demo.application.core.users

import org.springframework.stereotype.Service
import spring.hexagonal.structure.demo.domain.core.users.User
import spring.hexagonal.structure.demo.domain.core.users.UserRepository
import java.util.*

@Service
class UserService(private val userRepository : UserRepository) : IUserService {
    override fun findAll(): Iterable<User> {
        return userRepository.findAll()
    }

    override fun findByUUID(user_id: String): Optional<User> {
        return userRepository.findByUUID(user_id)
    }

    override fun findByEmail(email: String): Optional<User> {
        return userRepository.findByEmail(email)
    }

    override fun save(user: User): User {
        return userRepository.save(user)
    }

    override fun update(user: User): User {
        return userRepository.save(user)
    }

    override fun removeByUUID(user_id: String) {
        userRepository.removeByUUID(user_id)
    }
}