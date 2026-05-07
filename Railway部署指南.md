# 部署后端到 Railway

## 准备工作

1. 注册 Railway 账号：https://railway.app
2. 安装 Railway CLI：
```powershell
npm install -g @railway/cli
```

3. 登录：
```powershell
railway login
```

## 部署步骤

### 方法1：GitHub 部署（推荐）

1. 把 blog-backend 推到 GitHub 仓库
2. 在 Railway 中关联 GitHub 仓库
3. Railway 会自动检测并部署

### 方法2：CLI 部署

```powershell
cd blog-backend
railway init
railway up
```

## 配置环境变量

在 Railway 控制台设置：

| 变量名 | 值 |
|-------|-----|
| `DB_HOST` | 你的 MySQL 主机地址 |
| `DB_PORT` | 3306 |
| `DB_NAME` | blog |
| `DB_USER` | root |
| `DB_PASSWORD` | 你的密码 |

## 绑定 MySQL

 Railway 支持直接创建 MySQL 数据库：
1. Railway 控制台 → New Project → Add Database
2. 选择 MySQL
3. 复制连接信息到环境变量

## 部署后

- Railway 会给出访问 URL，如：`https://blog-backend.up.railway.app`
- 测试：`https://blog-backend.up.railway.app/api/articles`

## 修改前端 API 地址

部署后端后，修改前端文件中的 API 地址：

修改 `blog-frontend/js/main.js` 和 `blog-frontend/js/article.js`：

```javascript
const API_BASE = 'https://blog-backend.up.railway.app/api';
```

---

## Railway 免费额度

- 每月 500 小时计算时间
- 100GB 流量
- 适合个人项目练手
