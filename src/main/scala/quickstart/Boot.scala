package quickstart

import akka.actor.Props
import xitrum.{Config, Log, Server}

object Boot extends App with Log {

  Server.start()

  Config.actorSystem.actorOf(Props[BrunchActor]) ! "start"
}
