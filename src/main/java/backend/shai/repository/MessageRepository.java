package backend.shai.repository;


import backend.shai.model.Message;
import backend.shai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<User, Message> {

}
