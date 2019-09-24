package th.ku.bookservice;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}

