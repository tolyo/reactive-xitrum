package quickstart.action

import xitrum.{Action, Log}
import xitrum.annotation.{GET}

@GET("")
class SiteIndex extends Action with Log {

  def execute() {
    respondFile("public/indefddx.html")
  }

}
