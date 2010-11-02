package tekdays
import grails.test.*

class TekEventTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
		def tekEvent = new TekEvent(name: 'QuakeCon',
									city: 'Beijing' )
		assertEquals 'QuakeCon Beijing', tekEvent.toString()
    }
}
