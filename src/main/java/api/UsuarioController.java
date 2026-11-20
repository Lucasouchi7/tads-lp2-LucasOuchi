package api;

import br.edu.ifsp.biblioteca.service.UsuarioService;
import dto.NovoUsuario;
import dto.UsuarioDetalhe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;

    }

    @GetMapping
    public List<UsuarioDetalhe> listarTodos(){
        return this.usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDetalhe buscar(@PathVariable Long id){
        return this.usuarioService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioDetalhe> cadastrar(@RequestBody NovoUsuario dados){

        UsuarioDetalhe usrDetalhe = this.usuarioService.cadastrar(dados);

        return ResponseEntity
                .created(URI.create("/api/usuarios" + usrDetalhe.id()))
                .body(usrDetalhe);

    }
}
