package spring.hexagonal.structure.demo.domain.core.users

import java.util.*
import javax.persistence.*

@Entity(name = "users")
class User{
    @Id val id: UUID = UUID.randomUUID();
    @Column(name = "email")  val email: String = "";
    @Column(name = "password")  val password: String = "";
}