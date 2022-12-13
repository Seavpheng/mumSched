package mumsched.services;

import mumsched.domain.Block;
import mumsched.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    @Autowired
    BlockRepository blockRepository;

    public Iterable<Block> getBlocks(){
        return blockRepository.findAll();
    }

    public Block getBlock(long blockId){
        return blockRepository.getBlockById(blockId);
    }

    public void Save(Block block){
        try {
            blockRepository.save(block);
        }
        catch (Exception ex){}
    }

    public boolean update(Block block) {
        try {
            Block updateBlock =  blockRepository.getBlockById(block.getId());
            updateBlock.setName(block.getName());
            updateBlock.setActive(block.getActive());
            blockRepository.save(updateBlock);
        }
        catch (Exception e)
        {
            throw e;
        }
        return true;
    }

    public void delete (Long blockId){
        try {
            Block course = blockRepository.getBlockById(blockId);
            blockRepository.delete(course);
        }catch(Exception ex){
            throw  ex;
        }
    }

}
