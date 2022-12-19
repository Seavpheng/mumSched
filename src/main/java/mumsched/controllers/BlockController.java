package mumsched.controllers;

import mumsched.domain.Block;
import mumsched.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/blocks")
@Controller
public class BlockController {

    @Autowired
    BlockService blockService;

    @GetMapping("/list")
    public ModelAndView getList()
    {
        ModelAndView mav = new ModelAndView("block/list");
        mav.addObject("blocks", blockService.getBlocks());

        return mav;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        Block block = new Block();
        block.setActive(true);
        ModelAndView mav =new ModelAndView("block/create");
        mav.addObject(block);

        return mav;
    }

    @PostMapping("/create")
    public ModelAndView create(Block block){
        blockService.Save(block);
        return getList();
    }

    @PostMapping("/edit")
    public ModelAndView edit(Block block){
        boolean result = blockService.update(block);
        if(result == false){
            return edit(block.getId());
        }

        return getList();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer blockId )
    {
        ModelAndView mav = new ModelAndView("block/edit");
        mav.addObject("block", blockService.getBlock(blockId));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long blockId )
    {
        blockService.delete(blockId);
        return getList();
    }
}
