package com.company.project.spider.tumblr;

import com.conpany.project.Tester;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class TumblrSpiderTest extends Tester {

    @Resource
    TumblrSpider tumblrSpider;

    @Test
    public void start() {
        tumblrSpider.start("hjh2416");
    }
}