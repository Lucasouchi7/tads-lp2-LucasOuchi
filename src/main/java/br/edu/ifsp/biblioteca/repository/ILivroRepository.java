package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ILivroRepository  extends JpaRepository {

    Livro salvar(Livro livro);

    /**
     * "Containing" vira LIKE "%...% , "IgnoreCase" vira LOWER(...).
     *
     * SELECT * FROM livro WHERE LOWER (titulo) LIKE "%?";
     *
     * param trechoTitulo
     *
     * @return
     */

    List<Livro> listarTodos();

    /**
     * Retorna a lista de livros filtrados pelo trecho do título, porém, paginado.
     *
     * @param trechoTitulo
     * @param pagina
     * @return
     */

    Page <Livro> findByTituloContainingIgnoreCase(String trechoTitulo, Pageable pagina);

    Optional<Livro> buscarPorId(Long id);

    Optional<Livro> buscarPorIsbn(String isbn);

    List<Livro> buscarPorTitulo(String titulo);
}
