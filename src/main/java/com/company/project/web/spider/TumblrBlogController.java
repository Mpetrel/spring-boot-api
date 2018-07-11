package com.company.project.web.spider;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.spider.TumblrBlog;
import com.company.project.service.spider.TumblrBlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by madman on 2018/07/11.
*/
@RestController
@RequestMapping("/tumblr/blog")
public class TumblrBlogController {
    @Resource
    private TumblrBlogService tumblrBlogService;

    @PostMapping
    public Result add(@RequestBody TumblrBlog tumblrBlog) {
        tumblrBlogService.save(tumblrBlog);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tumblrBlogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TumblrBlog tumblrBlog) {
        tumblrBlogService.update(tumblrBlog);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TumblrBlog tumblrBlog = tumblrBlogService.findById(id);
        return ResultGenerator.genSuccessResult(tumblrBlog);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TumblrBlog> list = tumblrBlogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
