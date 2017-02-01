package com.klymchuk.swagger

import scala.reflect.runtime.{universe => ru}
import akka.actor.ActorRefFactory
import com.github.swagger.spray.SwaggerHttpService
import com.github.swagger.spray.model
import com.klymchuk.hello.HelloService
import com.github.swagger.spray.model.Info
import io.swagger.models.ExternalDocs
import io.swagger.models.auth.BasicAuthDefinition

/**
  * Created by iklymchuk on 2/1/17.
  */
class SwaggerDocService (context: ActorRefFactory) extends SwaggerHttpService {

  implicit def actorRefFactory = context
  override val apiTypes = Seq(ru.typeOf[HelloService])
  override val host = "localhost:8060"
  override val info = Info(version = "1.0")
  override val externalDocs = Some(new ExternalDocs("Core Docs", "http://acme.com/docs"))
  override val securitySchemeDefinitions = Map("basicAuth" -> new BasicAuthDefinition())

}
