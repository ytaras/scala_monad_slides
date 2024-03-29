case class Person(name: String, property: List[Address])
case class Address(location: String, phones: List[Phone])
case class Phone(code: Int, phone: Int) {
  val full = "(%03d) %07d" format (code, phone)
}

case class Issue(releaseId: Int)
case class Release(managerId: Int)
case class Manager(name: String)
