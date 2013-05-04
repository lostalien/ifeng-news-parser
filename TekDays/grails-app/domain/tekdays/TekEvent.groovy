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
                      sponsorships: Sponsorship,
                      tasks : Task,
                      messages : Message]

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
    volunteers(nullable: true)
    sponsorships(nullable: true)
    tasks(nullable: true)
    messages(nullable: true)
  }
}
