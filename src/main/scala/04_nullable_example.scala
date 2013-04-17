object NullableExample {

  object Repository {
    def issue(id: Int): Issue = if (id == 123) Issue(23) else null
    def release(id: Int): Release = if (id == 23) Release(55) else null
    def manager(id: Int): Manager = if (id == 55) Manager("Yuriy") else null
  }

  import Repository._
  def managerNameForIssue(id: Int) = {
    val nIssue = issue(id)
    if(nIssue != null) {
      val nRelease = release(nIssue.releaseId)
      if(nRelease != null) {
        val nManager = manager(nRelease.managerId)
        if (nManager != null) {
          nManager.name
        } else {
          null
        }
      } else {
        null
      }
    } else {
      null
    }
  }
}

