package racetrack

class Race {
		String name 
    Date startDateTime 
    String city 
    String state 
    Float distance 
    Float cost 
    Integer maxRunners = 100000 
 
    static hasMany = [registrations:Registration]
    
    static constraints = {
    }
}
