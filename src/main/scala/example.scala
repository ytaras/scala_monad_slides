
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
  println(NullableExample.managerNameForIssue(23))
  println(NullableExample.managerNameForIssue(123))
  println("Example using my option")
  println(OptionExample.managerNameForIssue(23))
  println(OptionExample.managerNameForIssue(123))
  println(OptionExample.managerNameForIssueMap(23))
  println(OptionExample.managerNameForIssueMap(123))
  println(OptionExample.managerNameForIssueFor(23))
  println(OptionExample.managerNameForIssueFor(123))
}
