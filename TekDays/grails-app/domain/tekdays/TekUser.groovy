package tekdays

class TekUser {
  String fullName
  String userName
  String password
  String email
  String website
  String bio

  String toString(){ fullName }

  static constraints = { 
    fullName(nullable: true )
    userName(nullable: true)
    email(nullable: true)
    website(nullable: true)
    bio( maxSize:5000, nullable: true )
  }
}
