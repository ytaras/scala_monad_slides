
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
  println("Example using scala map and flatMap")
  println(MapExample.getUserNames(sampleData))
  println(MapExample.getUserNamesLambda(sampleData))
  println(MapExample.getUserNamesShorterLambda(sampleData))
  println(MapExample.getUserPhones(sampleData))
  println(MapExample.getUserPhonesLambdas(sampleData))
  println("Example using scala for compehensions")
  println(ForExample.getUserNames(sampleData))
  println(ForExample.getUserPhones(sampleData))
  println("Example using java nulls")
  println(Nullable.managerNameForIssue(23))
  println(Nullable.managerNameForIssue(123))
}
