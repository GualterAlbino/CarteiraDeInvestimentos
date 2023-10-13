
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import java.util.UUID

interface UsuarioRepository {

    fun findAll(): List<Usuario>

    fun findById(usuarioId: UUID):Usuario? //Ao utilizar ? deixa condicional

    fun inserir(usuario: Usuario): Boolean
}