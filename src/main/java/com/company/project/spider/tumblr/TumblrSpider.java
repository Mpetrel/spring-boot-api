package com.company.project.spider.tumblr;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.model.spider.TumblrBlog;
import com.company.project.model.spider.TumblrImage;
import com.company.project.model.spider.TumblrUser;
import com.company.project.service.spider.TumblrBlogService;
import com.company.project.service.spider.TumblrImageService;
import com.company.project.service.spider.TumblrUserService;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: spring-boot-api-project-seed
 * @description:
 * @author: Larry
 * @create: 2018-07-11 10:20
 **/
@Slf4j
@Service
public class TumblrSpider {

    private static final String API_URL = "https://%s.tumblr.com/api/read/json?start=%s&num=200";
    private static final String RAW_IMG_URL = "http://data.tumblr.com/%s/%s_raw.%s";

    /**
     * 匹配原始图片pattern
     */
    private static final String rawImgPatternStr = ".*com/(\\w*)/(\\w*?)_1280\\.(\\w*)";
    private static final Pattern rawImgPattern = Pattern.compile(rawImgPatternStr);


    @Resource
    private TumblrImageService tumblrImageService;
    @Resource
    private TumblrBlogService tumblrBlogService;
    @Resource
    private TumblrUserService tumblrUserService;


    public JSONObject getDataFronAPI(String userName, int start) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = String.format(API_URL, userName, start);
        String response = HttpRequest.get(url).useProxy("127.0.0.1", 1080).body();
        if (response != null) {
            response = response.substring(0, response.length() - 2).replace("var tumblr_api_read = ", "");
            System.out.println(response);
            return JSONObject.parseObject(response);
        }
        return null;
    }


    /**
     * 开始抓取信息
     *
     * @param userName 用户名
     */
    public void start(String userName) {
        int start = 0;
        JSONObject data = getDataFronAPI(userName, start);

        while (data != null) {
            // 解析用户信息
            JSONArray posts = data.getJSONArray("posts");
            if (posts != null && !posts.isEmpty()) {
                posts.forEach((obj) -> {
                    JSONObject item = (JSONObject) obj;
                    if ("photo".equals(item.getString("type"))) {
                        // 生成blog信息
                        TumblrBlog blog = new TumblrBlog();
                        blog.setId(item.getLong("id"));
                        blog.setType(item.getString("type"));
                        blog.setUrl(item.getString("url"));
                        blog.setNoteCount(item.getString("note-count"));
                        blog.setHeadImage(item.getString("photo-url-1280"));
                        blog.setPostTime(item.getDate("unix-timestamp"));
                        blog.setCreateTime(new Date());
                        tumblrBlogService.save(blog);
                        // 生成图片信息
                        JSONArray photos = item.getJSONArray("photos");
                        photos.forEach((p) -> {
                            JSONObject photo = (JSONObject) p;
                            TumblrImage image = new TumblrImage();
                            image.setUrl(photo.getString("photo-url-1280"));
                            image.setOffset(photo.getString("offset"));
                            image.setCreateTime(new Date());
                            image.setRawUrl(parseRaw(image.getUrl()));
                            tumblrImageService.save(image);
                        });
                    }

                    // 设置用户信息
                    JSONObject postItem = (JSONObject)posts.get(0);
                    JSONObject tumblelog = postItem.getJSONObject("tumblelog");
                    TumblrUser user = new TumblrUser();
                    user.setAvatar(tumblelog.getString("avatar_url_512"));
                    user.setCname(tumblelog.getString("cname"));
                    user.setName(tumblelog.getString("name"));
                    user.setTimezone(tumblelog.getString("timezone"));
                    user.setUrl(tumblelog.getString("url"));
                    user.setTitle(tumblelog.getString("title"));
                    user.setId(Hashing.hmacMd5("mamba".getBytes()).hashBytes(user.getName().getBytes()).toString());
                    tumblrUserService.save(user);
                });
            }else {
                break;
            }
            start += 200 + 1;
            data = getDataFronAPI(userName, start);
        }
    }


    private String parseRaw(String url) {
        Matcher m = rawImgPattern.matcher(url);
        if (m.find()) {
            return String.format(RAW_IMG_URL, m.group(1), m.group(2), m.group(3));
        }
        return null;
    }

    public static void main(String[] args) {
        new TumblrSpider().start("hjh2416");
    }

}
