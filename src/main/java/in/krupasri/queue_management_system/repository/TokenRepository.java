package in.krupasri.queue_management_system.repository;

import in.krupasri.queue_management_system.entity.Token;
import in.krupasri.queue_management_system.entity.TokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token findTopByOrderByTokenNumberDesc();
    Optional<Token> findFirstByStatusOrderByTokenNumberAsc(TokenStatus status);


    List<Token> findByStatus(TokenStatus tokenStatus);
}