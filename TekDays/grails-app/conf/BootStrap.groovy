import tekdays.TekEvent
import tekdays.TekUser
import tekdays.Sponsor
import tekdays.Sponsorship

class BootStrap {

  def init = { servletContext ->

    def user1 = new TekUser( fullName:'黄晓静',
                              userName:'hxj',
                              password: '007')
    def user2 = new TekUser( fullName:'黄',
                              userName:'hxj',
                              password: '007')

    /*if (!user1.save()) {
      user1.errors.getAllErrors().each {
        error ->
        println "an error ocurred with user1:${error}"

      }
    }
    if (!user2.save()) {
      user2.errors.getAllErrors().each {
        error ->
        println "an error ocurred with user2:${error}"

      }
    }*/

    def event1 = new TekEvent(name: '雷神会议',
            city: 'Beijing',
            organizer: user1,
            venue: 'shuangjing',
            startDate: new Date('11/1/2010'),
            endDate: new Date('11/3/2010'),
            description: 'welcome you')


    
    def s1 = new Sponsor( name: "Sponsor1",
                           website: "www.s1.com",
                           description: "this is s1").save()

    def s2 = new Sponsor( name: "Sponsor2",
                           website: "www.s2.com",
                           description: "this is s2").save()

    def ss1 = new Sponsorship( tekEvent : event1,
                                sponsor : s1,
                                contributionType : "Cash",
                                description : "this is sponsorship1")

    s1.addToSponsorships( ss1 )
    s1.save()
    event1.addToSponsorships( ss1 )
    event1.addToVolunteers( user1 )
    event1.addToVolunteers( user2 )
    event1.addToRespondents("lost_alien@qq.com")
    event1.addToRespondents("lost_alien@sohu.com")
    event1.addToRespondents("lost_alien@sina.com")

    if (!event1.save()) {
      event1.errors.getAllErrors().each {
        error ->
        println "an error ocurred with user1:${error}"

      }
    }


  }
  def destroy = {
  }
}
