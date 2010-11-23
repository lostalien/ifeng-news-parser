package tekdays

class TekEvent {
  String name
  String city
  TekUser organizer
  String venue
  Date startDate
  Date endDate
  String description

  static hasMany = [volunteers: TekUser,
          respondents: String,
          sponsorships: Sponsorship]

  String toString() {
    "$name $city"
  }

  static constraints = {
    name(nullable: true)
    city(nullable: true)
    description(maxSize: 5000, nullable: true)
    organizer(nullable: true)
    venue(nullable: true)
    startDate(nullable: true)
    endDate(nullable: true)
    sponsorships(nullable: true)
  }
}
