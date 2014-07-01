package ru.eis.azurejay

import play.api.Logger
import play.api.libs.json.JsValue
import play.api.libs.ws._

/**
 * User: esypachev
 * Date: 01.07.14
 * Time: 16:23
 */
class AzureAdapter(serviceName: String, tableName: String) {

  import scala.concurrent.ExecutionContext.Implicits.global

  private val serviceUrl: String = s"https://$serviceName.azure-mobile.net/tables/$tableName"
  private val headers: Seq[(String,String)] = Seq(("Accept", "application/json"), ("Content-Type", "application/json"))

  def create(message: String) : Unit = {
    val request = WS.url(serviceUrl).withHeaders(headers:_*)
    request.post(message).map {
      response => Logger.info(response.status.toString)
    }
  }

  def create(message: JsValue) : Unit = {
    val request = WS.url(serviceUrl).withHeaders(headers:_*)
    request.post(message).map {
      response => Logger.info(response.status.toString)
    }
  }



}




