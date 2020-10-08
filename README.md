# Docker Instructions 
### 1.docker build -t spring:kanak https://github.com/kanaksharma412/springboot#master
### 2.docker container run --name demo -d -p 8080:8080 spring:kanak
### 3. Entry Pages
    *h2-console: localhost:8080/h2-console

    *list of users: /jpa/printAllUsers

    *Add new user: /jpa/addUser

    *Update user: /jpa/updatePassword/{id}

    *Delete user by id: /jpa/deleteUser/{id}
