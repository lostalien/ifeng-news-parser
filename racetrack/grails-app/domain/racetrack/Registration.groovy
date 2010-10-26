package racetrack

class Registration {
		
		Race race 
    String name 
    Date dateOfBirth 
    String gender = 'F' 
    String postalAddress 
    String emailAddress 
    Date createdAt = new Date() 
    static belongsTo = Race 
    static optionals = ["postalAddress" ]
    
    static constraints = {
    }
}
