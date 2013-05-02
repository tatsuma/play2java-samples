# How to use Guice and MyBatis in Play 

 1. add mybatis and guice dependency setting to appDependencies in Build.scala.
 2. create your AbstractModule and MybatisModule. (sample: modules.UserModule, modules.UserMyBatisModule)
 3. Setup injector in Global.java. 
 4. add an “@“ to controller mapping in conf/routes file.
 5. Inject Inject Inject.
