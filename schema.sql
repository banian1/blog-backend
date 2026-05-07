-- 创建数据库
CREATE DATABASE IF NOT EXISTS blog DEFAULT CHARACTER SET utf8mb4;

USE blog;

-- 创建文章表
CREATE TABLE IF NOT EXISTS article (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL COMMENT '标题',
    content TEXT COMMENT '内容',
    author VARCHAR(100) COMMENT '作者',
    category VARCHAR(50) COMMENT '分类',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- 插入测试数据
INSERT INTO article (title, content, author, category) VALUES
('第一篇文章', '这是我的第一篇博客文章，内容...', '张三', '技术'),
('第二篇文章', '这是我的第二篇博客文章，内容...', '张三', '生活'),
('Java基础', 'Java是一种面向对象的编程语言...', '李四', '技术');