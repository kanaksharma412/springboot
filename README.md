docker build -t spring:kanak https://github.com/kanaksharma412/springboot#master
docker container run -d -p 8080:8080 --name demo spring:kanak

entry pages:
	h2-consloe: localhost:8080/h2-console
	To get a list of all users: /jpa/printAllUsers
	Add a new user: /jpa/addUser
	Update user: /jpa/updatePassword/{id}
	Delete a user: /jpa/deleteUser/{id}
