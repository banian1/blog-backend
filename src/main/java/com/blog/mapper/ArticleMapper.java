package com.blog.mapper;

import com.blog.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 标识这是一个MyBatis的Mapper接口，Spring会自动扫描并创建实现类
public interface ArticleMapper {

        // @Select、@Insert、@Update、@Delete是MyBatis提供的注解，用于定义SQL语句，#{...}表示参数占位符，会自动映射方法参数到SQL中
        @Select("SELECT * FROM article ORDER BY create_time DESC")
        List<Article> findAll();

        @Select("SELECT * FROM article WHERE id = #{id}")
        Article findById(Long id);

        @Select("SELECT * FROM article WHERE title = #{title}")
        Article findByTitle(String title);

        @Insert("INSERT INTO article(title, content, author, category, create_time, update_time) " +
                        "VALUES(#{title}, #{content}, #{author}, #{category}, #{createTime}, #{updateTime})")
        @Options(useGeneratedKeys = true, keyProperty = "id")
        int insert(Article article);

        @Update("UPDATE article SET title=#{title}, content=#{content}, author=#{author}, " +
                        "category=#{category}, update_time=#{updateTime} WHERE id=#{id}")
        int update(Article article);

        @Delete("DELETE FROM article WHERE id = #{id}")
        int delete(Long id);

        @Select("SELECT COUNT(*) FROM article")
        long count();

}