package quickstart.action

import xitrum.{Action, Log}
import xitrum.annotation.GET

import scala.util.Random

@GET("")
class SiteIndex extends Action with Log {

  def execute() {
    respondFile("public/index.html")
  }

}

@GET("/quote")
class QuoteAction extends Action with Log {

  val quoteList = List(
    Quote("Larry Wall", "There is more than one method to our madness"),

    Quote("Chuck Norris", "I only use the Roundhouse kick"),

    Quote("Eric Raymond","Being a social outcast helps you stay concentrated on the really important things, like thinking and hacking")
  )

  def execute() {
    respondJson(quoteList(Random.nextInt(quoteList.size)))
  }
}

case class Quote(author: String, content: String)

