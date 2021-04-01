package spring.hexagonal.structure.demo.presentation.controllers.users

import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import spring.hexagonal.structure.demo.application.core.users.IUserService
import spring.hexagonal.structure.demo.domain.core.users.User
import spring.hexagonal.structure.demo.domain.core.users.UserRepository
import spring.hexagonal.structure.demo.presentation.controllers.base.BaseController

@RestController
@RequestMapping("users")
class UserController (
        private val userRepository: UserRepository,
        private val userService: IUserService) : BaseController() {

    @GetMapping("")
    @ResponseBody
    fun findAll(
            @RequestParam(required = false) page : Int,
            @RequestParam(required = false) per_page : Int,
    ): ResponseEntity<*>? {
        try{
            if(per_page > 0)
                return Ok(userRepository.findAll(PageRequest.of(page.toInt(), per_page.toInt())))
            return Ok(userRepository.findAll())
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }

    @PostMapping(path = [""])
    fun save(@RequestBody user: User) : ResponseEntity<*>? {
        try{
            return Ok(userService.save(user));
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }

    @PutMapping(path = [""])
    fun update(@RequestBody user: User) : ResponseEntity<*>? {
         try{
            return Ok(userService.save(user));
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }

    @DeleteMapping(path = ["{user_id}"])
    fun deleteById(user_id: String) : ResponseEntity<*>? {
        try{
            userRepository.removeByUUID(user_id);
            return Ok(true);
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }

    @GetMapping(path = ["{user_id}"])
    fun findById(@PathVariable user_id : String) : ResponseEntity<*>? {
        try{
            return Ok(userRepository.findByUUID(user_id));
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }

    @GetMapping(path = ["/email/{email}"])
    fun findByEmail(@PathVariable email : String) : ResponseEntity<*>? {
        try{
            return Ok(userRepository.findByEmail(email));
        }catch (exception:Exception){
            return BadRequest(exception);
        }
    }
}
