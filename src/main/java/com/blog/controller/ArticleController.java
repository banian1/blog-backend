package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Map是Java中的一个接口，表示一个键值对集合，可以用来存储和访问数据。在这个控制器中，我们使用Map<String, Object>来构建统一的响应格式，包含code、data和message等字段，以便前端更方便地处理响应结果。
@Slf4j
@RestController // 标识这是一个RESTful控制器
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping // => GET /api/articles
    // ResponseEntity是Spring提供的一个类，用于构建HTTP响应，包含状态码、响应头和响应体
    // Map<String, Object>是一个通用的响应格式，包含code、data和message等字段
    public ResponseEntity<Map<String, Object>> getAllArticles() {
        log.info("try to get all articles");
        List<Article> articles = articleService.getAllArticles();
        log.info("got {} articles", articles.size());
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", articles);
        result.put("total", articleService.getArticleCount());
        // ok方法表示返回一个200 OK的响应，参数是响应体
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}") // => GET /api/articles/{id}
    public ResponseEntity<Map<String, Object>> getArticle(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        Map<String, Object> result = new HashMap<>();
        if (article != null) {
            result.put("code", 200);
            result.put("data", article);
        } else {
            result.put("code", 404);
            result.put("message", "文章不存在");
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping // => POST /api/articles
    public ResponseEntity<Map<String, Object>> createArticle(@RequestBody Article article) {
        Article created = articleService.createArticle(article);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", created);
        result.put("message", "创建成功");
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        Article updated = articleService.updateArticle(id, article);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", updated);
        result.put("message", "更新成功");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "删除成功");
        return ResponseEntity.ok(result);
    }
}