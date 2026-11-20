
package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILivroRepository extends JpaRepository<Livro, Long> {

    /*
     * Busca livros pelo trecho do título,
     * ignorando letras maiúsculas e minúsculas.
     */
    Page<Livro> findByTituloContainingIgnoreCase(
            String trechoTitulo,
            Pageable pagina
    );

    /*
     * Busca um livro pelo ISBN.
     */
    Optional<Livro> findByIsbn(String isbn);

}
