# How to use Guice and MyBatis in Play. modified to be able to use multiple databases. 

 1. add mybatis and guice dependency setting to appDependencies in Build.scala.
 2. create your PrivateModule and MybatisModule. (sample: modules.UserModule, modules.AdminModule, etc.. See package)
 3. Expose binded-class in your PrivateModule. 
 4. Setup guice and mybatis in Global.java. 
 5. add an “@“ to controller mapping in conf/routes file.
 6. Inject Inject Inject.
