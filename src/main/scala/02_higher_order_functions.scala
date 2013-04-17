object MapExample {

  def userToName(person: Person) = person.name

  def getUserNames(people: List[Person]) =
    people map userToName
  def getUserNamesLambda(people: List[Person]) =
    people map { x => x.name }
  def getUserNamesShorterLambda(people: List[Person]) =
    people map { _.name }


  def addressToPhones(address: Address): List[String] = address.phones map { _.full }
  def personToPhones(person: Person): List[String] =
     // [error]  found   : List[List[String]]
     // [error]  required: List[String]
     // person.property map addressToPhones
     person.property flatMap addressToPhones

  def getUserPhones(people: List[Person]): List[String] =
    people flatMap personToPhones
}
