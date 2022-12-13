package mumsched.repositories;

import mumsched.domain.Block;
import org.springframework.data.repository.CrudRepository;


public interface BlockRepository extends CrudRepository<Block, Integer> {

    Block getBlockById(long blockId);
}
