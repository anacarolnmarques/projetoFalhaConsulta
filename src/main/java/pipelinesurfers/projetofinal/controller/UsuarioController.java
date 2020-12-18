package pipelinesurfers.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pipelinesurfers.projetofinal.dao.UserDAO;
import pipelinesurfers.projetofinal.dto.UsuarioDto;
import pipelinesurfers.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")

public class UsuarioController {

    @Autowired // Injecao de dependencia
    private UserDAO dao;

 @GetMapping("/all")
    public List<Usuario> listarTodos() {
        List<Usuario> lista = (List<Usuario>) dao.findAll();

        return lista;
    } 

   /*  @GetMapping("/id/{id}") // {Nome da variavel}
    public ResponseEntity<User> BuscaPorId(@PathVariable int id) { // int id - nome precisa ser igual ao declarado no
                                                                   // GETMAPPING
        User user = dao.findById(id).orElse(null);

        if (user != null) {
            user.setSenha("******");
            return ResponseEntity.ok(user); // ok = 200
            
        }
        return ResponseEntity.notFound().build(); // // not found 404
    } */

   /*  @PostMapping("/new")
    public ResponseEntity<User> novoUsuario(@RequestBody User user){
        User newUser = dao.save(user);
        return ResponseEntity.ok(newUser);

    } 
 */
   /*  @PostMapping("/email")
    public ResponseEntity<UserDto> buscaPorEmail(@RequestBody User user) {
        User userFinded = dao.findByEmail(user.getEmail());

        if (userFinded != null) {
            UserDto userDto = new UserDto(userFinded);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    } */

    @PostMapping("/loginemail")
    public ResponseEntity<UsuarioDto> loginPorEmail(@RequestBody Usuario user) {
        Usuario userFinded = dao.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (userFinded != null) {
            UsuarioDto userDto = new UsuarioDto(userFinded);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }

     @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody Usuario user) {
        Usuario userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFinded != null) {
            if (user.getSenha().equals(userFinded.getSenha())) {
                UsuarioDto usuarioDto = new UsuarioDto(userFinded);
                return ResponseEntity.ok(usuarioDto); 
            }
            //return ResponseEntity.status(401).build();
        }
        return ResponseEntity.status(401).build();
    }
 
   /*  @GetMapping("/id3/{id}")
    public ResponseEntity<Object> buscarUserPersonalizado(@PathVariable int id){
        Object userFinded = dao.buscarUsuariosPorId(id);

        if(userFinded != null){
            return ResponseEntity.ok(userFinded);

        }
        return ResponseEntity.notFound().build();


    } */

}
