dataSource {
  pooled = true
  driverClassName = "org.hsqldb.jdbcDriver"
  //driverClassName = "com.mysql.jdbc.Driver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "create-drop" // one of 'create', 'create-drop','update'
      url = "jdbc:hsqldb:mem:devDB;characterEncoding=utf8"
      //url = "jdbc:mysql://localhost:3306/tekdays?useUnicode=true&characterEncoding=utf-8"

    }
  }
  test {
    dataSource {
      dbCreate = "update"
      url = "jdbc:mysql://localhost:3306/tekdays?useUnicode=true&characterEncoding=utf-8"
    }
  }
  production {
    dataSource {
      dbCreate = "update"
      url = "jdbc:hsqldb:file:prodDb;shutdown=true"
    }
  }
}
