sealed trait MyOption[A] {
  def flatMap[B](f: A => MyOption[B]): MyOption[B]
  def map[B](f: A => B): MyOption[B]
}
case class MySome[A](value: A) extends MyOption[A] {
  def flatMap[B](f: A => MyOption[B]) = f(value)
  def map[B](f: A => B) = MySome(f(value))
}
case class MyNone[A] extends MyOption[A] {
  def flatMap[B](f: A => MyOption[B]) = MyNone[B]
  def map[B](f: A => B) = MyNone[B]
}

object OptionExample {
  object Repository {
    import NullableExample.Repository._
    def nullableToMyOption[A](value: A): MyOption[A] = if (value == null) MyNone[A] else MySome(value)
    def mIssue(id: Int): MyOption[Issue] = nullableToMyOption(issue(id))
    def mRelease(id: Int): MyOption[Release] = nullableToMyOption(release(id))
    def mManager(id: Int): MyOption[Manager] = nullableToMyOption(manager(id))
  }
  import Repository._

  def managerNameForIssue(id: Int): MyOption[String] = mIssue(id) match {
    case MySome(issue) => mRelease(issue.releaseId) match {
      case MySome(release) => mManager(release.managerId) match {
        case MySome(manager) => MySome(manager.name)
        case _ => MyNone[String]
      }
      case _ => MyNone[String]
    }
    case _ => MyNone[String]
  }

  def managerNameForIssueMap(id: Int): MyOption[String] =
    mIssue(id) flatMap {
      issue    =>       mRelease(issue.releaseId) flatMap {
      release  =>       mManager(release.managerId) map {
      manager  =>       manager.name  } } }
}
