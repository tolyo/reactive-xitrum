package quickstart.action

import io.netty.handler.codec.http.HttpResponseStatus
import xitrum.annotation.{GET, POST}
import xitrum.{Action, Log, SkipCsrfCheck}

import scala.util.Random

object Data {
  var quoteList = List(
    Quote("Larry Wall", "The is more than one method to our madness"),

    Quote("Chuck Norris", "I only use the Roundhouse kick"),

    Quote("Eric Raymond","Being a social outcast helps you stay concentrated on the really important things, like thinking and hacking")
  )

}

@GET("")
class SiteIndex extends Action with Log {

  def execute() {
    respondFile("public/index.html")
  }

}

@GET("/quote")
class QuoteAction extends Action with Log {

  def execute() {
    respondJson(Data.quoteList(Random.nextInt(Data.quoteList.size)))
  }
}

@POST("/quote")
class SaveQuote extends Action with Log with SkipCsrfCheck {

  def execute() = {
    log.info(params("author").head)
    log.info(params("newQuote").head)
    Data.quoteList = Quote(params("author").head, params("newQuote").head) :: Data.quoteList
    response.setStatus(HttpResponseStatus.OK)
  }
}

case class Quote(author: String, content: String)

