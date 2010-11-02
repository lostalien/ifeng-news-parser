import tekdays.TekEvent

class BootStrap {

    def init = { servletContext ->
		def event1 = new TekEvent(name:'QuakeCon',
					city:'Beijing',
					organizer:'sina',
					venue:'shuangjing',
					startDate: new Date('11/1/2010'),
					endDate: new Date('11/3/2010'),
					description:'welcome you')
		if(!event1.save()){
			println '**** error when saveing event1'
		}
    }
    def destroy = {
    }
}
