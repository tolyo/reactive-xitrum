package quickstart

import java.io.{BufferedReader, InputStreamReader}
import java.util.Scanner

import xitrum.{Log, Server}

object Boot extends Log {
  def main(args: Array[String]) {
    Server.start()
    Log.info("Brunch starting")
    var p = Runtime.getRuntime.exec("npm start")
    val s = new Scanner(p.getInputStream())
    while (s.hasNextLine) {
      Log.info(s.nextLine)
    }
  }
}
