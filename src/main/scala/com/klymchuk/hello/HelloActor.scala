package com.klymchuk.hello

import akka.actor.{Actor, ActorLogging}

/**
  * Created by iklymchuk on 2/1/17.
  */

object HelloActor {
  case object AnonymousHello
  case class Hello(name: String)
  case class Greeting(greeting: String)
}

class HelloActor extends Actor with ActorLogging {

  import HelloActor._

  def receive: Receive = {
    case AnonymousHello => { sender ! Greeting("Hello") }
    case Hello(name) => sender ! Greeting(s"Hello, $name")
  }

}
