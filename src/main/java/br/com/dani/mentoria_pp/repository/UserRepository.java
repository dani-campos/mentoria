package br.com.dani.mentoria_pp.repository;

import br.com.dani.mentoria_pp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
