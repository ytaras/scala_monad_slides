object ValidationExample {
  import scalaz._
  object Repository {
    import NullableExample.Repository._
    def required[A, B](value: A, error: B): Validation[B, A] =
      if (value == null)
        Failure(error)
      else
        Success(value)

    def vIssue(id: Int): Validation[String, Issue] = required(issue(id), "Issue not found")
    def vRelease(id: Int): Validation[String, Release] = required(release(id), "Release not found")
    def vManager(id: Int): Validation[String, Manager] = required(manager(id), "Manager not found")
  }
  import Repository._

  def managerNameForIssue(id: Int): Validation[String, String] = for {
    issue   <- vIssue(id)
    release <- vRelease(issue.releaseId)
    manager <- vManager(release.managerId)
  } yield manager.name
}
