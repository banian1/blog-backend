# 博客后端 API

基于 Spring Boot + MyBatis + MySQL 的博客后端服务。

## 技术栈

- Spring Boot 3.2
- MyBatis 3.0
- MySQL
- Maven

## 本地运行

1. **创建数据库**
```bash
mysql -u root -p < schema.sql
```

2. **修改数据库配置**
编辑 `src/main/resources/application.yml` 中的数据库连接信息。

3. **运行项目**
```bash
mvn spring-boot:run
```

4. **访问 API**
- 文章列表: http://localhost:8080/api/articles
- 文章详情: http://localhost:8080/api/articles/1

## API 接口

| 方法 | 路径 | 说明 |
|-----|------|-----|
| GET | /api/articles | 获取文章列表 |
| GET | /api/articles/{id} | 获取文章详情 |
| POST | /api/articles | 创建文章 |
| PUT | /api/articles/{id} | 更新文章 |
| DELETE | /api/articles/{id} | 删除文章 |

## 请求/响应示例

### 创建文章 POST /api/articles
```json
{
  "title": "新文章标题",
  "content": "文章内容...",
  "author": "作者名",
  "category": "分类"
}
```

### 响应格式
```json
{
  "code": 200,
  "data": { ... },
  "message": "操作成功"
}
```
