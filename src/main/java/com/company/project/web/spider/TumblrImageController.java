package com.company.project.web.spider;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.spider.TumblrImage;
import com.company.project.service.spider.TumblrImageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by madman on 2018/07/11.
*/
@RestController
@RequestMapping("/tumblr/image")
public class TumblrImageController {
    @Resource
    private TumblrImageService tumblrImageService;

    @PostMapping
    public Result add(@RequestBody TumblrImage tumblrImage) {
        tumblrImageService.save(tumblrImage);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tumblrImageService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TumblrImage tumblrImage) {
        tumblrImageService.update(tumblrImage);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TumblrImage tumblrImage = tumblrImageService.findById(id);
        return ResultGenerator.genSuccessResult(tumblrImage);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TumblrImage> list = tumblrImageService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
