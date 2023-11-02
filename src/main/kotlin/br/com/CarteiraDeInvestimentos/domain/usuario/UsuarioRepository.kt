import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import java.util.UUID

interface UsuarioRepository {

    fun findAll(): List<Usuario>

    fun findById(usuarioId: UUID):Usuario? //Ao utilizar ? deixa condicional

    fun findByEmail(email: String): Usuario?

    fun inserir(usuario: Usuario): Boolean

    fun excluir(usuarioId: UUID):Boolean

    fun atualizar(usuario: Usuario):Boolean
}