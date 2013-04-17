object ExceptionsExample {
  object Repository {
    import NullableExample.Repository._

    @throws(classOf[IllegalArgumentException])
    def nullToException[B](value: B, explain: String): B = if (value != null)
      value
    else
      throw new IllegalArgumentException(explain)

    def eIssue(id: Int) = nullToException(issue(id), "Issue not found")
    def eRelease(id: Int) = nullToException(release(id), "Issue not found")
    def eManager(id: Int) = nullToException(manager(id), "Issue not found")
  }

  import Repository._

  def managerNameForIssue(id: Int) = {
    val issue   = eIssue(id)
    val release = eRelease(issue.releaseId)
    val manager = eManager(release.managerId)
    manager.name
  }
}
