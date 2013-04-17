trait HaskellMonad[A] {
  def bind[B](mapper: A => HaskellMonad[B]): HaskellMonad[B]
  // vvvvv This is static method, which can't be done in scala
  def pure(value: A): HaskellMonad[A]
}

// Theoretic Scala monad
trait ScalaMonad[A] {
  def flatMap[B](flatMapper: A => ScalaMonad[B]): ScalaMonad[B]
  def map[B](mapper: A => B): ScalaMonad[B]
  // Nice feature, but won't be covered in scope of presentation
  //def filter(predicate: A => Boolean): ScalaMonad[A]
}

object ForExample {
  def getUserNames(people: List[Person]): List[String] = for {
    person <- people
  } yield person.name

  def getUserPhones(people: List[Person]): List[String] = for {
    person  <- people
    address <- person.property
    phone   <- address.phones
  } yield phone.full


}
