import org.kiy0taka.spock.shell.ShellSpec

class GreetingSpec extends ShellSpec {

    def "greet"() {
        when:
        run 'greeting.sh'

        then:
        status == 0

        and:
        lines[0] == 'Hello !'
    }

    def "greet with username"() {
        when:
        run 'greeting.sh', 'Spock'

        then:
        status == 0

        and:
        lines[0] == 'Hello Spock!'
    }

    def "greet with custom message"() {
        given:
        export 'GREET', 'Goodbye'

        when:
        run 'greeting.sh', 'Spock'

        then:
        lines[0] == 'Goodbye Spock!'
    }
}
