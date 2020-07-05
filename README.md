前端地址：https://github.com/kangbinqiang/blog-font.git
后端地址：https://github.com/kangbinqiang/blog-backend.git
# 项目搭建

## 搭建父工程

### 选择maven项目

![image-20200704115007948](E:\typora\Typora\data\image-20200704115007948.png)

### 填写GroupId和ArtifactId

![image-20200704115104620](E:\typora\Typora\data\image-20200704115104620.png)

### 此时项目结构如下

![image-20200704115228795](E:\typora\Typora\data\image-20200704115228795.png)

### 修改pom.xml文件，如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.blog</groupId>
    <artifactId>blog</artifactId>
    <version>1.0-SNAPSHOT</version>

    
    <packaging>pom</packaging>

</project>
```

## 搭建子模块

### 在blog项目的基础上，搭建接口模块api

![image-20200704115741925](E:\typora\Typora\data\image-20200704115741925.png)

![image-20200704115824083](E:\typora\Typora\data\image-20200704115824083.png)

### 依次建立consumer、provider，此时项目结构如下

![image-20200704120051240](E:\typora\Typora\data\image-20200704120051240.png)

## 修改每个module的pom文件

### 根项目的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.blog</groupId>
    <artifactId>blog</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!--    子模块-->
    <modules>
        <module>api</module>
        <module>consumer</module>
        <module>provider</module>
    </modules>

    <!--打包类型-->
    <packaging>pom</packaging>

    <!--    添加spring的parent-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
    </parent>

    <!--    设置我们用到的版本-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
        <dubbo.version>2.5.5</dubbo.version>
        <zkclient.version>0.10</zkclient.version>
        <lombok.version>1.16.18</lombok.version>
        <spring-boot.version>1.5.7.RELEASE</spring-boot.version>
    </properties>


    <!--    项目依赖管理-->
    <dependencyManagement>
        <dependencies>
            <!-- springboot-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
                <version>${spring-boot.version}</version>
            </dependency>

            <!--springboot-web-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <version>${spring-boot.version}</version>
            </dependency>

            <!--lombok-->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
                <scope>provided</scope>
            </dependency>

            <!--dubbo-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>dubbo</artifactId>
                <version>${dubbo.version}</version>
            </dependency>

            <!--zookeeper-->
            <dependency>
                <groupId>com.101tec</groupId>
                <artifactId>zkclient</artifactId>
                <version>${zkclient.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>
```

### api的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>blog</artifactId>
        <groupId>com.blog</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>api</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```

### provider的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>blog</artifactId>
        <groupId>com.blog</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>provider</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.blog</groupId>
            <artifactId>blog</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
        </dependency>
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
        </dependency>
        <dependency>
            <groupId>com.blog</groupId>
            <artifactId>api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>


</project>
```

### consumer的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>blog</artifactId>
        <groupId>com.blog</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>consumer</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.blog</groupId>
            <artifactId>blog</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
        </dependency>
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
        </dependency>
        <dependency>
            <groupId>com.blog</groupId>
            <artifactId>api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

# 项目配置

## 测试接口

### 在api中创建以下两个文件

![image-20200704123001126](E:\typora\Typora\data\image-20200704123001126.png)

#### Article:

```java
package com.boot.model;


import lombok.Data;

import java.util.Date;

@Data
public class Article implements Serializable{

    private String name;

    private String type;

    private String author;

    private Date publishDate;

    private Integer score;
}


```

#### TestService:

```java
package com.boot.service;

import com.boot.model.Article;

public interface TestService {

    String descArticle();

    Article find();
}


```

### 在provider中创建文件结构及文件

![image-20200704132400696](E:\typora\Typora\data\image-20200704132400696.png)

#### TestServiceImpl：

```java
package com.boot.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.boot.model.Article;
import com.boot.service.TestService;

import java.util.Date;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public String descArticle() {
        return "this is kbq's Article";
    }

    @Override
    public Article find() {
        Article article = new Article();
        article.setAuthor("kbq");
        article.setName("Dubbo");
        article.setPublishDate(new Date());
        article.setScore(100);
        article.setType("program");
        return article;
    }
}

```

#### ProviderApplication：

```java
package com.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### spring-dubbo.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://code.alibabatech.com/schema/dubbo
       http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <dubbo:application name="provider"/>
    <!-- 注册中心的ip地址 -->
    <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
    <!-- 扫描注解包路径，多个包用逗号分隔，不填pacakge表示扫描当前ApplicationContext中所有的类 -->
    <dubbo:annotation package="com.boot.service.impl"/>
</beans>
```

#### application.yml:

```yml
# 在这里编写springboot的配置信息
server:
  port: 8091
```

### 在consumer中创建文件结构以及文件

![image-20200704133539939](E:\typora\Typora\data\image-20200704133539939.png)

#### TestController:

```java
package com.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.model.Article;
import com.boot.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Reference(version = "1.0.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.descArticle();
    }

    @GetMapping("user")
    public Article user() {
        return testService.find();
    }
}
```

#### ConsumerApplication:

```java
package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
```

#### spring-dubbo.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://code.alibabatech.com/schema/dubbo
       http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <dubbo:application name="consumer"/>
    <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
    <dubbo:annotation package="com.boot.controller"/>
</beans>
```

#### application.yml:

```yml
# 在这里编写springboot的配置信息
server:
  port: 8090
```

以上就是项目的初始搭建过程，后面配置模块只会以各自的文件出现，只需要在上述的基础上增加即可

# 整合MongoDB

准备MongoDB的环境，建立名为blog的库

1、打开命令窗口，切换到mongodb安装目录下的“bin”目录中

2、启动服务。输入命令：”mongod --dbpath E:\mongodb\data

推荐使用Robot工具连接MongoDB，建好如下图所示：

![image-20200705034618983](E:\typora\Typora\data\image-20200705034618983.png)

## 添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

## 添加配置

```yml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/blog
```

## Entity:

```java
package com.boot.service.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "article")
@Data
public class ArticleDO {

    private String title;

    private String author;

    private Date createdTime;
}
```

## Mapper:

```java
package com.boot.service.mapper;

import com.boot.service.entity.ArticleDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleMapper extends MongoRepository<ArticleDO, String> {
}
```

## ServiceImpl:

```java
package com.boot.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.boot.model.Article;
import com.boot.service.TestService;
import com.boot.service.entity.ArticleDO;
import com.boot.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {


    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public String descArticle() {
        List<ArticleDO> all = articleMapper.findAll();
        return JSON.toJSONString(all);
    }

    @Override
    public Article find() {
        Article article = new Article();
        article.setAuthor("kbq");
        article.setName("Dubbo");
        article.setPublishDate(new Date());
        article.setScore(100);
        article.setType("program");
        return article;
    }

    @Override
    public void add() {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setAuthor("kangbinqiang");
        articleDO.setTitle("Dubbo");
        articleDO.setCreatedTime(new Date());
        articleMapper.insert(articleDO);
    }
}
```

## Controller:

```java
package com.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.model.Article;
import com.boot.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Reference(version = "1.0.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.descArticle();
    }

    @GetMapping("user")
    public Article user() {
        return testService.find();
    }

    @GetMapping("add")
    public void add() {
        testService.add();
    }
}
```

结果如图：

### add()

![image-20200705041528089](E:\typora\Typora\data\image-20200705041528089.png)

### hello()

![image-20200705041638591](E:\typora\Typora\data\image-20200705041638591.png)