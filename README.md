# springcloud-security-oauth2
密码模式，可用于前后分离


1.执行user.sql,使用的是redistoken，把auth-server配置文件中关于redis和mysql的配置改成自己的，
用户只给了admin权限，如果想了解完整的rbac权限，可查看https://github.com/microideal/spring-security-oauth2-sso   
 
2.登陆获取token：http://localhost:8086/auth/oauth/token?grant_type=password&username=microideal&password=123456

3.访问：http://localhost:8086/auth/user/microideal?access_token=dba6cdab-7766-48b1-b794-1061de463eaa   有admin权限就可访问

4. 注销：http://localhost:8086/auth/oauth/token?access_token=dba6cdab-7766-48b1-b794-1061de463eaa  

具体的访问方式请查看a,b,c图片
