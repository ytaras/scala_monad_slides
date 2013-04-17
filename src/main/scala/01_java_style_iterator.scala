object JavaStyleIteratorExample {
  import java.util.ArrayList
  def getUserNames(people: List[Person]) = {
    val output = new ArrayList[String](people.size)
    for(person <- people) {
      output add person.name
    }
    output
  }

  def getUserPhones(people: List[Person]) = {
    val output = new ArrayList[String](people.size)
    for(person <- people) {
      for(address <- person.property) {
        for(phone <- address.phones) {
          output add phone.full
        }
      }
    }
    output
  }

}
