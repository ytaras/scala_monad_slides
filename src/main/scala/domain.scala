case class Person(name: String, property: List[Address])
case class Address(location: String, phones: List[Phone])
case class Phone(code: Int, phone: Int) {
  val full = "(%03d) %07d" format (code, phone)
}

object ShowDomain extends App {
  println("Example of phone full:")
  println(Phone(68, 1234).full)
  val sampleData = List(
    Person("John", List(
      Address("Lviv", List(
        Phone(68, 1234),
        Phone(98, 543122)
      ))
    )),
    Person("James", Nil),
    Person("Jessica", List(
      Address("Kyiv", Nil),
      Address("Vinnytsya", List(
        Phone(352, 99999)
      ))
    ))
  )

  println("Example using java-style iteration")
  println(JavaStyleIteratorExample.getUserNames(sampleData))
  println(JavaStyleIteratorExample.getUserPhones(sampleData))
  println("Example using scala giher order iteration")
  println(MapExample.getUserNames(sampleData))
  println(MapExample.getUserNamesLambda(sampleData))
  println(MapExample.getUserNamesShorterLambda(sampleData))
  println(MapExample.getUserPhones(sampleData))
}
