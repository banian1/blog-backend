package com.blog.service;

import com.blog.entity.Article;
import com.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAllArticles() {
        return articleMapper.findAll();
    }

    public Article getArticleById(Long id) {
        return articleMapper.findById(id);
    }

    public Article findArticleByTitle(String title) {
        return articleMapper.findByTitle(title);
    }

    public Article createArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.insert(article);
        return article;
    }

    public Article updateArticle(Long id, Article article) {
        Article existing = articleMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("文章不存在");
        }
        article.setId(id);
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
        return article;
    }

    public void deleteArticle(Long id) {
        articleMapper.delete(id);
    }

    public long getArticleCount() {
        return articleMapper.count();
    }
}