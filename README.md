# TJU-SE-Comprehensive-Practice
## 前端项目介绍
### 项目简介
本项目是一个基于 HTML5、CSS3 和 JavaScript（ES6 以上）的前端项目，旨在实现一个类似 “饿了么” 的点餐系统。通过该项目，学员能够强化前端项目的需求分析、系统设计、编码和调试能力，掌握复杂程序的模块划分、数据结构定义、模块接口设计和模块流程设计等技能，具备一定的设计和实施程序实验以及对实验结果进行分析的能力，具有主动获取知识能力和意识及独立解决问题的能力，同时初步具备工程技术文档写作能力。
### 功能模块

  * **首页** ：显示点餐分类信息。可点击点餐分类小图片跳转到商家列表页面，点击下方菜单栏中的 “订单” 可跳转到历史订单页面。
  * **商家列表页面** ：展示商家列表信息。点击某个商家可跳转到该商家的详细信息页面。
  * **商家详细信息页面** ：呈现商家详细信息及所属食品信息。点击 “去结算” 按钮可跳转到确认订单页面。
  * **确认订单页面** ：显示订单信息和选择送货地址。点击送货地址可跳转到送货地址列表页面，点击 “去支付” 按钮可跳转到支付页面。
  * **在线支付页面** ：展示订单信息及订单明细信息。
  * **登录页面** ：实现用户登录功能。点击 “登陆” 按钮可跳转到上一个页面，点击 “去注册” 按钮可跳转到注册页面。
  * **注册页面** ：提供注册新用户功能。点击 “注册” 按钮可跳转到登陆页面。
  * **历史订单页面** ：显示用户历史订单信息。点击某个历史订单可对订单明细信息进行显示和隐藏。

### 技术栈

  * **前端技术** ：HTML5、CSS3、JavaScript（ES6 以上）
  * **开发工具** ：HBuilder、VSCode、Chrome 浏览器
  
### 项目结构
  * **frontend/img** ：存放项目图片资源
    * **readme.txt** ：图片资源说明文件
  
  * **frontend/book** ：存放项目技术文档
  
  * **frontend/src** ：存放项目源码文件
    * **css** ：存放项目样式文件
    * **framework** ： 存放第三方库文件，以及一些共通的css文件（自定义css图标、css重置）
    * **js** ：存放项目 JavaScript 文件


以下是一份简化后的 README：

## 饿了么 Servlet 版项目

### 项目概述

本项目参照饿了么官网网页版制作，专注于点餐业务线功能，采用前后端分离架构，前端使用 Vue.js 框架，后端使用 Servlet 技术，通过 AJAX 进行前后端数据交互，旨在帮助学习者掌握相关开发技能。

### 项目特点

  * 前后端分离，便于开发和维护
  * 使用 Vue.js 框架提升前端开发效率和用户体验
  * 采用 Servlet 技术实现后端业务逻辑
  * 使用 AJAX 进行前后端数据交互，提高应用的响应速度

### 技术栈

  * 前端：Vue.js、axios、Vue Router
  * 后端：Servlet、JDBC、MySQL
  * 其他：Maven（项目构建和依赖管理）

### 环境搭建

#### 后端环境搭建

  1. **开发工具** ：Spring Tool Suite（STS）
  2. **JDK** ：配置 JDK 8
  3. **Tomcat** ：配置 Tomcat 8.5
  4. **数据库** ：MySQL（创建对应数据库及表结构）

#### 前端环境搭建

  1. **Node.js 和 npm** ：安装 Node.js，自动配置 npm
  2. **Vue CLI** ：全局安装 Vue CLI（`npm install -g @vue/cli`）
  3. **项目创建** ：使用 Vue CLI 创建项目（`vue create project-name`），选择手动配置，包含 Babel 和 Router
  4. **项目启动** ：进入项目目录，运行`npm run serve`启动项目

### 项目目录结构

```
demo/
├── .idea/
├── out/
├── reference/
├── src/
│   └── com.neusoft.elm/
│       ├── controller/
│       │   ├── BusinessController.java
│       │   ├── CartController.java
│       │   ├── DeliveryAddressController.java
│       │   ├── FoodController.java
│       │   ├── OrdersController.java
│       │   └── UserController.java
│       ├── dao/
│       │   ├── Impl/
│       │   ├── BusinessDao.java
│       │   ├── CartDao.java
│       │   ├── DeliveryAddressDao.java
│       │   ├── FoodDao.java
│       │   ├── OrderDetailDao.java
│       │   ├── OrdersDao.java
│       │   └── UserDao.java
│       ├── filter/
│       │   └── CorsFilter.java
│       ├── framework/
│       │   └── DispatcherServlet.java
│       ├── po/
│       │   ├── Business.java
│       │   ├── Cart.java
│       │   ├── DeliveryAddress.java
│       │   ├── Food.java
│       │   ├── OrderDetail.java
│       │   ├── Orders.java
│       │   └── User.java
│       ├── service/
│       │   ├── impl/
│       │   │   ├── BusinessServiceImpl.java
│       │   │   ├── CartServiceImpl.java
│       │   │   ├── DeliveryAddressServiceImpl.java
│       │   │   ├── FoodServiceImpl.java
│       │   │   ├── OrdersServiceImpl.java
│       │   │   └── UserServiceImpl.java
│       │   ├── BusinessService.java
│       │   ├── CartService.java
│       │   ├── DeliveryAddressService.java
│       │   ├── FoodService.java
│       │   ├── OrdersService.java
│       │   └── UserService.java
│       └── util/
│           ├── CommonUtil.java
│           └── DBUtil.java
```

### 业务逻辑

  1. **用户注册与登录** ：用户可以通过手机号和密码进行注册和登录，系统会验证用户信息的合法性。
  2. **商家与食品展示** ：用户登录后，可以浏览不同分类下的商家和食品信息。
  3. **购物车管理** ：用户可以将喜欢的食品加入购物车，也可以修改购物车中的食品数量或删除食品。
  4. **订单处理** ：用户确认订单信息后，提交订单，系统会生成订单编号并存储订单信息，包括订单状态（未支付、已支付）。
  5. **地址管理** ：用户可以添加、修改和删除收货地址，方便订单配送。

### 接口示例

  * **获取商家列表** ：`GET /api/business/list`
  * **获取食品列表** ：`GET /api/food/list`
  * **添加到购物车** ：`POST /api/cart/add`
  * **创建订单** ：`POST /api/orders/create`
  * **获取订单列表** ：`GET /api/orders/list`

### 数据库设计

项目中设计了商家表、食品表、购物车表、订单表、订单明细表和用户表等，各表之间通过外键关联，实现数据的完整性和一致性。

