case class Person(name: String, property: List[Address], emails: List[String])
case class Address(street: String, city: String,
  state: String, phones: List[Phone])
case class Phone(code: Int, phone: Int) {
  val full = "(%03d) %07d" format (code, phone)
}

object ShowDomain extends App {
  println(Phone(68, 1234).full)
}
