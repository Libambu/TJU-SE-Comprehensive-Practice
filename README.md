# TJU-SE-Comprehensive-Practice

## 饿了么前端VUE版本

### 项目概述

本项目是饿了么点餐系统的前端部分，基于 Vue.js 框架开发，采用前后端分离架构，通过 AJAX 与后端进行数据交互，实现了点餐业务线的完整功能。

### 功能特点

  * **用户注册与登录** ：用户可以通过手机号和密码进行注册和登录，系统会验证用户信息的合法性。
  * **商家与食品展示** ：用户登录后，可以浏览不同分类下的商家和食品信息。
  * **购物车管理** ：用户可以将喜欢的食品加入购物车，也可以修改购物车中的食品数量或删除食品。
  * **订单处理** ：用户可以确认订单信息，提交订单，并查看订单状态。
  * **地址管理** ：用户可以添加、修改和删除收货地址，方便订单配送。

### 技术栈

  * **前端框架** ：Vue.js
  * **路由管理** ：Vue Router
  * **HTTP请求** ：Axios
  * **构建工具** ：Vue CLI

### 环境搭建

  1. **Node.js 和 npm 安装** ：确保已安装 Node.js，可通过命令`node -v`和`npm -v`查看版本。
  2. **Vue CLI 安装** ：命令行输入`npm install -g @vue/cli`进行全局安装。
  3. **项目克隆** ：从仓库克隆项目到本地。
  4. **依赖安装** ：进入项目目录，运行`npm install`安装项目依赖。

### 项目结构

```
src/
│  App.vue
│  common.js
│  main.js
│
├─assets
│  │  img
│
├─components
│      Footer.vue
│
├─router
│      index.js
│
└─views
        AddUserAddress.vue
        BusinessInfo.vue
        BusinessList.vue
        EditUserAddress.vue
        Index.vue
        Login.vue
        Mine.vue
        OrderList.vue
        Orders.vue
        Payment.vue
        Register.vue
        UserAddress.vue
```



### 运行项目

  * **开发环境** ：运行`npm run serve`，项目将在本地启动开发服务器，默认端口为 8080，可通过`http://localhost:8080`访问。
  * **生产构建** ：运行`npm run build`，将生成生产环境的构建文件，位于`dist`目录下。



## 后端Servlet 版项目

### 项目概述

本项目参照饿了么官网网页版制作，专注于点餐业务线功能，采用前后端分离架构，前端使用 Vue.js 框架，后端使用 Servlet 技术，通过 AJAX 进行前后端数据交互，旨在帮助学习者掌握相关开发技能。
业务流程
![img](https://github.com/Libambu/TJU-SE-Comprehensive-Practice/blob/main/img/img1.png)
MVC架构解决方案
![img](https://github.com/Libambu/TJU-SE-Comprehensive-Practice/blob/main/img/img2.png)
事务处理解决方案
![img](https://github.com/Libambu/TJU-SE-Comprehensive-Practice/blob/main/img/img3.png)
### 项目特点

  * 前后端分离，便于开发和维护
  * 使用 Vue.js 框架提升前端开发效率和用户体验
  * 采用 Servlet 技术实现后端业务逻辑
  * 使用 AJAX 进行前后端数据交互，提高应用的响应速度

### 技术栈

  * JDBC
  * Servlet
  * MySQL

### 环境搭建

#### 后端环境搭建

  1. **开发工具** ：IDEA
  2. **JDK** ：配置 JDK 21
  3. **Tomcat** ：配置 Tomcat 8.5
  4. **数据库** ：MySQL（创建对应数据库及表结构）


### 项目目录结构

```
backend-servlet/
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

  * **获取商家列表** ：http://localhost:8080/elm/BusinessController/getBusinessById
  * **获取食品列表** ：http://localhost:8080/elm/FoodController/listFoodByBusinessId
  * **添加到购物车** ：http://localhost:8080/elm/CartController/addCart
  * **创建订单** ：http://localhost:8080/elm/OrdersController/createOrder
  * **获取订单列表** ：http://localhost:8080/elm/OrdersController/listOrders

### 数据库设计

项目中设计了商家表、食品表、购物车表、订单表、订单明细表和用户表等，各表之间通过外键关联，实现数据的完整性和一致性。

