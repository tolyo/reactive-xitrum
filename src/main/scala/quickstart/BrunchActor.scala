package quickstart

import java.util.Scanner

import akka.actor.Actor
import xitrum.Log

/**
  * Actor to start and monitor Brunch app
  */
class BrunchActor extends Actor with Log {

  private var started = false

  override def receive = {
    case _ =>
      if (!started) {
        started = true;
        Log.info("Brunch starting")
        val p = Runtime.getRuntime.exec("npm start")
        val s = new Scanner(p.getInputStream)
        while (s.hasNextLine) {
          Log.info(s.nextLine)
        }
      }
  }
}
